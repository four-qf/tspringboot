package com.qiux.tspringboot.mq;

import com.alibaba.fastjson.JSONObject;
import com.qiux.tspringboot.entity.User;
import org.apache.commons.lang.time.DateUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author qiux
 * @Date 2022/3/21
 * @since
 */
public class MqProducerOriginal {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {

        DefaultMQProducer mqProducer = new DefaultMQProducer("crue-cat-group");
        //1.设置mq服务地址
        mqProducer.setNamesrvAddr("qx.learn.com:9876;qx2.learn.com:9876");
        mqProducer.setVipChannelEnabled(false);



        //2.创建消息 TOPIC TAG MSG
        User user = new User();
        user.setEmail("cat@126.com");
        user.setUsername("KK");
        Message message = new Message("crue-cat-test", "smile", JSONObject.toJSONString(user).getBytes(StandardCharsets.UTF_8));
//        message.putUserProperty("id", "1");
//        message.putUserProperty("name", "qx");
//        message.setDelayTimeLevel(5);

        //链接
        mqProducer.start();

        //发送消息


        SendResult send = mqProducer.send(message, 1000);
        System.out.println("producer time:" + DateUtils.toCalendar(new Date()).getTime());
        System.out.println("send result :" + send);

        //关闭链接
        mqProducer.shutdown();

    }


}
