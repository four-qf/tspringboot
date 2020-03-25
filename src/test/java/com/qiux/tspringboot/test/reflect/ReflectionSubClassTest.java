package com.qiux.tspringboot.test.reflect;

import org.reflections.Reflections;

import java.lang.reflect.Type;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
public class ReflectionSubClassTest {

    public static void main(String[] args) {

        Reflections reflections = new Reflections("java.lang.reflect");
        System.out.println(reflections.getSubTypesOf(Type.class));
    }

}
