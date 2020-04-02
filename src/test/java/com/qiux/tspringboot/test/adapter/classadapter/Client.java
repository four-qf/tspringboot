package com.qiux.tspringboot.test.adapter.classadapter;

/**
 * @author qiuxian
 * @date 2020/4/2
 */
public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        System.out.println(target.electric5V());
    }

}
