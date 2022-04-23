package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.mapper.UserMapper;
import com.qiux.tspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiux
 * @Date 2022/4/22
 * @since
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public User create(User user) {
        int row = userMapper.insert(user);
        return row > 0 ? user : null;
    }


}
