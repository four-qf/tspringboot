package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.mapper.UserMapper;
import com.qiux.tspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public User create(User user) throws Exception {
        int row = userMapper.insert(user);
//        throw new Exception("插入user失败");
        return row > 0 ? user : null;
    }


}
