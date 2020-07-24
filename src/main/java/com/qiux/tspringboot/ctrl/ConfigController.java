package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private User user;

    @RequestMapping("/get")
    public String get() {
        return user.getId();
    }
}