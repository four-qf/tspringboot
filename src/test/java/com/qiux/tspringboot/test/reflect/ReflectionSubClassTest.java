package com.qiux.tspringboot.test.reflect;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Slf4j
public class ReflectionSubClassTest {

    public static void main(String[] args) {

        Reflections reflections = new Reflections();
        log.info("{}'s child[{}]", "BeanFactory", reflections.getSubTypesOf(ConfigurableListableBeanFactory.class));

    }

}
