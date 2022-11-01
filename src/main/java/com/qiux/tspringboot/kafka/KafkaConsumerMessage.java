package com.qiux.tspringboot.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author qiux
 * @date 2022/11/1
 * @since
 */
public class KafkaConsumerMessage {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "43.138.133.31:9092,43.138.133.31:9093");
        properties.setProperty("group.id", "test");
//        properties.setProperty()
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties, new StringDeserializer(), new StringDeserializer());
        kafkaConsumer.subscribe(Arrays.asList("test-rep01"));
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofNanos(1000));
            consumerRecords.forEach(record -> {
                System.out.println(String.format("key:%s, value: %s, offset: %s, partition:%s", record.key(), record.value(), record.offset(), record.partition()));
            });
        }
    }

}
