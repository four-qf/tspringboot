package com.qiux.tspringboot.effective_java.clone;

/**
 * @author qiux
 * @Date 2022/8/1
 * @since 引用克隆：会生成一个新的引用地址，但两个指向的是同一个对象
 */

class Son {

    String name;
    Integer age;

    public Son(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

public class ReferenceClone {

    public static void main(String[] args) {
        Son son1 = new Son("jerry", 19);
        Son son2 = son1;
        System.out.println(son1 == son2);
        son2.age = 28;
        System.out.println(son1);
        System.out.println(son2);

        System.out.println(son1 == son2);
        System.out.println(son1.age);
        System.out.println(son2.age);

    }

}
