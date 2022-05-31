package com.qiux.tspringboot.effective_java.reference;

import java.lang.ref.SoftReference;

/**
 * @author qiux
 * @Date 2022/5/29
 * @since
 */
public class SoftReferenceTest {

    public static void main(String[] args) {

//        SoftReference<Student> softReference = new SoftReference<>(new Student());
//        Student student = softReference.get();
//        System.out.println(student);
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());
        byte[] bytes = new byte[1024*1024*10];
        System.out.println(softReference.get());
    }


}
