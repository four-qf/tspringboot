package com.qiux.tspringboot.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author qiux
 * @date 2022/11/3
 * @since
 */
@RequestMapping("/test-kafka")
@RestController
public class KafkaTestController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic.test}")
    private String topic;

    @GetMapping("/send")
    public Object testSendMessage(String message) {
        ListenableFuture<SendResult<String,Object>> send = kafkaTemplate.send(topic, message);
        try {
            SendResult<String,Object> result = send.get();
            return result.getRecordMetadata().timestamp();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

}

