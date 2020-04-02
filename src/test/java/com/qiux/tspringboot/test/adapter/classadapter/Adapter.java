package com.qiux.tspringboot.test.adapter.classadapter;

/**
 * @author qiuxian
 * @date 2020/4/2
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public int electric5V() {
        return electric220v()/44;
    }
}
