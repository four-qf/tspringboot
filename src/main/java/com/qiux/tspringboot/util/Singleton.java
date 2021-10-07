package com.qiux.tspringboot.util;

/**
 * @author qiuxian
 * @date 2021/7/13
 */
public class Singleton {

    private static Singleton instance ;

    public static Singleton getInstance() {

        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }


        }
        return instance;
    }



}
