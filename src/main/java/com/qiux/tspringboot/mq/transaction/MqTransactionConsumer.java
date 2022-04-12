package com.qiux.tspringboot.mq.transaction;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author qiux
 * @Date 2022/3/23
 * @since
 */
public class MqTransactionConsumer {
    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer mqPushConsumer = new DefaultMQPushConsumer();
        //配置mq服务器信息
        mqPushConsumer.setNamesrvAddr("101.35.101.154:9876;162.14.67.209:9876");
        mqPushConsumer.setConsumerGroup("crue-cat-transaction-group-test");
        mqPushConsumer.setVipChannelEnabled(false);
        //设置广播模式，每个消费者都会去消费消息
//        mqPushConsumer.setMessageModel(MessageModel.BROADCASTING);

        //订阅消息
        mqPushConsumer.subscribe("crue-cat-transaction","*");

        //注册监听器
        mqPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                msgs.forEach(msg -> {
                    String topic = msg.getTopic();
                    String tags = msg.getTags();
                    byte[] body = msg.getBody();
                    String bodyMsg = new String(body, StandardCharsets.UTF_8);
                    System.out.println(String.format("A topic:[%s], tags:[%s], rev msg : [%s]", topic, tags, bodyMsg ));
                });

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        mqPushConsumer.start();

    }

}
