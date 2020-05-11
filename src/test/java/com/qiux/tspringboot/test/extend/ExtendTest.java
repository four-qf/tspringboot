package com.qiux.tspringboot.test.extend;

/**
 * @author qiuxian
 * @date 2020/4/19
 */
public interface ExtendTest {

    public interface ExtendTestA extends ExtendTest {

    }

    public interface ExtendTestB extends ExtendTest {

    }

    public interface ExtendTestC extends ExtendTestA,ExtendTestB {

    }

}