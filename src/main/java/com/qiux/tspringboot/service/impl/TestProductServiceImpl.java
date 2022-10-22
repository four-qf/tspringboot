package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author qiux
 * @Date 2022/10/18
 * @since
 */
@Service
public class TestProductServiceImpl<T> implements TestService<T> {
    @Override
    public String submit(T t) {
        return "product";
    }

}
