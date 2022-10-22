package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.User;

/**
 * @author qiux
 * @Date 2022/4/22
 * @since
 */
public interface UserService {

    User queryById(Integer id);

    User create(User user) throws Exception;

}
