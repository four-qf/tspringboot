package com.qiux.tspringboot.test;

/**
 * @author qiuxian
 * @date 2020/5/18
 */
public class VolatileTest {

    private volatile int count = 0 ;

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.setCount();
            }
        });

        thread.start();
        System.out.println(volatileTest.count);

    }

    public  void setCount() {
        count++;
    }

}
