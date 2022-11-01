package com.qiux.tspringboot.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author qiux
 * @date 2022/11/1
 * @since
 */
public class KafkaSendMessage {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Object> props = new HashMap<>();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "43.138.133.31:9092,43.138.133.31:9093");
        KafkaProducer kafkaProducer = new KafkaProducer(props, new StringSerializer(), new StringSerializer());
        Future send = kafkaProducer.send(new ProducerRecord("test-rep01","test", "123"));
        System.out.println(send.get());

    }

}
