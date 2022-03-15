package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.service.cache.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiux
 * @Date 2022/3/15
 * @since
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserCacheService userCacheService;

    @PostMapping("/cache/add/{userId}")
    public String setCache(@PathVariable("userId") Integer userId, User user) {
        userCacheService.add(userId, user);
        return "ok";
    }

    @GetMapping("/cache/query/{userId}")
    public User query(@PathVariable("userId") Integer userId) {
        User user = userCacheService.get(userId);
        return user;
    }

}
