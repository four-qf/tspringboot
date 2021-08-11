package com.qiux.tspringboot.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author qiuxian
 * @date 2021/4/28
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "crue-cat-test", consumerGroup="crue-cat-dev-test-group")
public class CrueCateConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object o) {
         log.info("msg:{}", o);
    }
}
