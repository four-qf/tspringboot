package com.qiux.tspringboot.effective_java.reference;

import java.lang.ref.WeakReference;

/**
 * @author qiux
 * @Date 2022/5/30
 * @since
 */
public class WeakReferenceTest {

    public static void main(String[] args) {

        WeakReference<Student> weakReference = new WeakReference<>(new Student());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

    }

}
