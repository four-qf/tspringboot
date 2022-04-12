package com.qiux.tspringboot.mq.order;

import com.alibaba.fastjson.JSONObject;
import com.qiux.tspringboot.entity.User;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author qiux
 * @Date 2022/3/21
 * @since 测试顺序发送mq消息
 */
public class MqOrderProducer {

    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {

        DefaultMQProducer mqProducer = new DefaultMQProducer("crue-cat-group");
        //1.设置mq服务地址
        mqProducer.setNamesrvAddr("101.35.101.154:9876;162.14.67.209:9876");
        mqProducer.setVipChannelEnabled(false);
        //2.创建消息 TOPIC TAG MSG
        String topic = "crue-cat-order-test";
        String tags = "smile";

        mqProducer.start();
        mqProducer.setSendMsgTimeout(1000000);

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setEmail("cat" + i +"@126.com");
            user.setUsername("July"+i);
            Message message = new Message(topic, tags, JSONObject.toJSONString(user).getBytes(StandardCharsets.UTF_8));
            message.putUserProperty("id", String.valueOf(i));

            SendResult send = mqProducer.send(message);
            System.out.println("send result:" + send.toString() + ", i:" + i);
            Thread.sleep(200);
        }
        mqProducer.shutdown();

    }

}
