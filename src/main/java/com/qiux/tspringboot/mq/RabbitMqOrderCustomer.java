package com.qiux.tspringboot.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qiuxian
 * @date 2020/5/27
 */
@Slf4j
@Component
public class RabbitMqOrderCustomer {

    @RabbitListener(queues = "order" )
    public void orderProcess(String content) {
        log.info("RabbitMqMessage queue order = {}", content);
    }

}
