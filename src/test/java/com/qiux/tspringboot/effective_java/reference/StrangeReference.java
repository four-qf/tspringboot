package com.qiux.tspringboot.effective_java.reference;

/**
 * @author qiux
 * @Date 2022/5/29
 * @since
 */

class Student {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Student被回收了");
    }
}

public class StrangeReference {

    public static void main(String[] args) {
        Student student = new Student();
        student = null;
        System.gc();
    }

}
