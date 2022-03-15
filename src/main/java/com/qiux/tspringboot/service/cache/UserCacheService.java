package com.qiux.tspringboot.service.cache;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.redis.RedisHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiux
 * @Date 2022/3/15
 * @since
 */
@Configuration
public class UserCacheService {

    @Autowired
    private RedisHelp redisHelp;

    public void add(Integer userId, User user) {
        String key = UserCacheConstant.key(userId);
        redisHelp.set(key, user);
    }

    public User get(Integer userId) {
        String key = UserCacheConstant.key(userId);
        User user = redisHelp.get(key);
        return user;
    }
}
