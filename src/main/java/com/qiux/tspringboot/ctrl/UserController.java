package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.service.UserService;
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

    @Autowired
    private UserService userService;

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

    @GetMapping("/query/{userId}")
    public User queryById(@PathVariable("userId") Integer userId) {
        User user = userService.queryById(userId);
        return user;
    }

    @PostMapping("/create")
    public User create(User user) {
        try {
            user = userService.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
