package com.qiux.tspringboot.mq;

import com.alibaba.fastjson.JSONObject;
import com.qiux.tspringboot.entity.Student;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiuxian
 * @date 2020/5/25
 */
@Component
public class RabbitMqSender {

    @Autowired
    private RabbitMessagingTemplate rabbitTemplate;

    @Autowired
    private RabbitMqConfig rabbitMqConfig;

    public void send(Student student)  {
        rabbitTemplate.convertAndSend(rabbitMqConfig.exchange, rabbitMqConfig.routingkey, JSONObject.toJSONString(student));
    }
}
