package com.qiux.tspringboot.test;

import java.util.Random;

/**
 * @author qiux
 * @Date 2022/3/3
 * @since
 */
public class OutMemoryJprofileTest {

    public static void main(String[] args) {
        String str = "";
        while (true) {
            str += str + new Random().nextInt(999999999);
        }
    }

}
