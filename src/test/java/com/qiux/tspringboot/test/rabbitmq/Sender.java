package com.qiux.tspringboot.test.rabbitmq;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.mq.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuxian
 * @date 2020/5/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Sender {

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Test
    public void send() {
        rabbitMqSender.send(new Student());
    }

}
