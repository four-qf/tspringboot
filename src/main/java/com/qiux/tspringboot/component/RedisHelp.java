package com.qiux.tspringboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author qiux
 * @Date 2022/3/10
 * @since
 */
@Configuration
public class RedisHelp {

    @Autowired
    private RedisTemplate redisTemplate;

    public <T> void set(String key, T obj) {
        redisTemplate.opsForValue().set(key, obj);
    }

    public <T> T get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        return (T) o;
    }

}
