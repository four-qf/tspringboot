package com.qiux.tspringboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareMessageListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author qiux
 * @date 2022/11/3
 * @since
 */
@Slf4j
@Component
public class KafkaConsumerTest {

//    @Override
//    public void onMessage(Object data) {
//
//    }


    @KafkaListener(topics = {"test-rep01"})
    public String consumer(String message) {
        log.info("topic:test-rep01, message:{}", message);
        return message;
    }

}
