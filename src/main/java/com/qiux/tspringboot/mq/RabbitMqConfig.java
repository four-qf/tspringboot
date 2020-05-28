package com.qiux.tspringboot.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qiuxian
 * @date 2020/5/26
 */
@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.topic.exchange}")
    public String exchange;

    @Value("${spring.rabbitmq.topic.routingkey}")
    public String routingkey;

    @Value("${spring.rabbitmq.queue}")
    public String queue;

}
