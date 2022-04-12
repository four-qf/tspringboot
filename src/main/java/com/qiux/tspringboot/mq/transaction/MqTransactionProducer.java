package com.qiux.tspringboot.mq.transaction;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiux
 * @Date 2022/3/23
 * @since
 */
public class MqTransactionProducer {

    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {

        TransactionMQProducer mqProducer = new TransactionMQProducer("crue-cat-transaction-group");
        mqProducer.setNamesrvAddr("101.35.101.154:9876;162.14.67.209:9876");

        mqProducer.start();

        //设置事务监听
        mqProducer.setTransactionListener(new TransactionListener() {

            private ConcurrentHashMap<String, Integer> msgStatusMap = new ConcurrentHashMap<>();

            // -1 失败回滚 0 处理中 1 成功
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                String resource = "mybatis-config.xml";
                InputStream inputStream = null;

                String transactionId = msg.getTransactionId();
                System.out.println("--------executeLocalTransaction---------,transactionId:" + transactionId);
                try {
                    inputStream = Resources.getResourceAsStream(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                    msgStatusMap.put(transactionId, -1);
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                SqlSession session = sqlSessionFactory.openSession();
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user = new User();
                user.setUsername("Ketty");
                user.setPhone("18908019767");
                user.setEmail("18908019767@126.com");
                user.setStatus("0");
                msgStatusMap.put(transactionId, 0);
                try {
                    int rows = mapper.insert(user);
                    System.out.println("insert user , result: " + rows);
                    session.commit();
                    Thread.sleep(1000*60 +20000);
                } catch (Exception e) {
                    e.printStackTrace();
                    msgStatusMap.put(transactionId, -1);
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } finally {

                    session.close();
                }
                msgStatusMap.put(transactionId, 1);
                System.out.println("--------executeLocalTransaction---------,msgStatusMap:" + msgStatusMap);

                return LocalTransactionState.COMMIT_MESSAGE;
            }

            //Mq producer send msg done, to check msg what is success to send.
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {

                String transactionId = msg.getTransactionId();
                int status = msgStatusMap.get(transactionId);

                System.out.println(String.format("checkLocalTransaction transId: %s, status: %s", transactionId, status ));

                switch (status) {
                    case -1: return LocalTransactionState.ROLLBACK_MESSAGE;
                    case 0: return LocalTransactionState.UNKNOW;
                    case 1: return LocalTransactionState.COMMIT_MESSAGE;
                }

                System.out.println(String.format("checkLocalTransaction------------ transId: %s, status: %s", transactionId, status ));
                return LocalTransactionState.UNKNOW;
            }

        });

        Message message = new Message("crue-cat-transaction", "h".getBytes(StandardCharsets.UTF_8));
        mqProducer.sendMessageInTransaction(message,1);
        mqProducer.shutdown();

    }

}
