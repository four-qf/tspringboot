package com.qiux.tspringboot.test.adapter;

/**
 * @author qiuxian
 * volatile 待看
 * @date 2020/4/3
 */
public class VolatileTest {

    private int count = 0;

    public void write(){
        count ++ ;
    }

    public int read() {
        return count;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("write");
                volatileTest.write();
            }

        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 200000; i++) {

                }
                System.out.println(volatileTest.read());
            }
        });
        thread2.start();
        thread1.start();

    }

}
