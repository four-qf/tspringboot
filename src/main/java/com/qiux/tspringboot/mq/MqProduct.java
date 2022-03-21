package com.qiux.tspringboot.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author qiux
 * @Date 2022/3/21
 * @since
 */
public class MqProduct {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {

        DefaultMQProducer mqProducer = new DefaultMQProducer("crue-cat-group");
        //1.设置mq服务地址
        mqProducer.setNamesrvAddr("162.14.67.209:9876");
        mqProducer.setVipChannelEnabled(false);
        //2.创建消息 TOPIC TAG MSG
        Message message = new Message("crue-cat-test", "smile", "I'm very happy".getBytes(StandardCharsets.UTF_8));

        //链接
        mqProducer.start();

        //发送消息
        SendResult send = mqProducer.send(message,10000);

        System.out.println(send);

        //关闭链接
        mqProducer.shutdown();

    }


}
