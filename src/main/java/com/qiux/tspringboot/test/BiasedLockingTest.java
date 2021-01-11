package com.qiux.tspringboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author: qiux
 * @date: 2021-01-08
 * @des: 偏向锁测试
 *  * 开启偏向锁参数：
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 耗时1232ms左右
 * -XX:+UseBiasedLocking  耗时2623ms左右
 * 仅用偏向锁 耗时2862ms左右
 * */
public class BiasedLockingTest {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        testSynBiasedLock();
        System.out.println(System.currentTimeMillis() - time1);

    }

    public static void testSynBiasedLock() {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 100000000; i++) {
            vector.add(100);
            //add是synchronized操作
        }
    }

    public static void testNoSynBiaseLock() {
        List<Integer> list = new ArrayList<>();
        for (int i =0 ; i< 100000000; i++) {
            list.add(100);
            //add是非synchronized操作
        }
    }

}