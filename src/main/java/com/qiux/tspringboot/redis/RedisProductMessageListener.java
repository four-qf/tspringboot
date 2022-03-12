package com.qiux.tspringboot.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiux
 * @Date 2022/3/12
 * @since
 */
@Slf4j
@Configuration
public class RedisProductMessageListener implements MessageContentsDelegate {

    @Override
    public void handleMessage(String text) {
        log.info("RedisProductMessageListener---------------msg:{}", text);
    }

    @Override
    public void handleMessage(byte[] bytes) {

    }
}
