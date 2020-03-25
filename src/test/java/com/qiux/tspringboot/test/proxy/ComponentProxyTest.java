package com.qiux.tspringboot.test.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ComponentProxyTest {

    @Autowired
    private MyComponent component;

    @Test
    public void targetClass(){
        log.info("MyComponent.class:{}", component.getClass());
        log.info("AopUtils.getTargetClass:{}", AopUtils.getTargetClass(component));

    }

}
