package com.qiux.tspringboot.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qiuxian
 * @date 2020/5/25
 */
@Slf4j
@Component
public class RabbitMqCustomizer {

    @RabbitListener(queues = "product" )
    public void productProcess(String content){
        log.info("RabbitMqMessage queue product = {}", content);
    }


}
