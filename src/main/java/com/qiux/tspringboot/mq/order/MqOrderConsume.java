package com.qiux.tspringboot.mq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author qiux
 * @Date 2022/3/21
 * @since
 */
public class MqOrderConsume {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer mqPushConsumer = new DefaultMQPushConsumer();
        //配置mq服务器信息
        mqPushConsumer.setNamesrvAddr("101.35.101.154:9876;162.14.67.209:9876");
        mqPushConsumer.setConsumerGroup("crue-cat-group-order-test");
        mqPushConsumer.setVipChannelEnabled(false);

        MessageSelector messageSelector = MessageSelector.bySql("id like %1% ");

        //订阅消息
        mqPushConsumer.subscribe("crue-cat-order-test", messageSelector);

        mqPushConsumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                msgs.forEach(msg -> {
                    String topic = msg.getTopic();
                    String tags = msg.getTags();
                    byte[] body = msg.getBody();
                    String bodyMsg = new String(body, StandardCharsets.UTF_8);
                    System.out.println(String.format("topic:[%s], tags:[%s], rev msg : [%s],  brokerName:{%s}", topic, tags, bodyMsg, context.getMessageQueue().getBrokerName()));

                });

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        mqPushConsumer.start();

    }

}
