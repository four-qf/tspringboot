package com.qiux.tspringboot;

/**
 * @author qiux
 * @Date 2022/8/17
 * @since
 */
public class OOMSize {

    public static void main(String[] args) {
        long max = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        long heapSize = Runtime.getRuntime().totalMemory() / 1024 / 1024;

        System.out.println("最大的堆内存：" + max);
        System.out.println("堆初始大小：" + heapSize);

        System.out.println("系统大小：" + max * 4 /1024 );
        System.out.println("系统大小：" + heapSize * 64 /1024);


    }

}
