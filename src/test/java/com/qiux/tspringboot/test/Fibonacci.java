package com.qiux.tspringboot.test;

/**
 * @author qiuxian
 * @date 2020/3/19
 */
public class Fibonacci {

    private static int f (int n) {
        if (n < 2) {
            return 1;
        } else {
            return f(n-2) + f(n-1);
        }
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i =0; i < 5; i ++) {
            System.out.println(f(i));
            count += f(i);
        }
        System.out.println(count);

    }

}
