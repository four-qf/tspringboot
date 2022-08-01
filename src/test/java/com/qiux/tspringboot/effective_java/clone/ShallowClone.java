package com.qiux.tspringboot.effective_java.clone;

/**
 * @author qiux
 * @Date 2022/8/1
 * @since 浅拷贝：如果是基础类型拷贝的是值，如果是引用类型拷贝的是对象的内存地址，但只复制引用不复制引用的对象
 */
class Father {

    String name;

    int age;

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Daughter implements Cloneable {

    String name;

    int age;

    Father father;

    public Daughter(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Daughter(String name, int age, Father father) {
        this.name = name;
        this.age = age;
        this.father = father;
    }


    @Override
    public String toString() {
        return "Daughter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", father=" + father +
                '}';
    }

    @Override
    protected Daughter clone() throws CloneNotSupportedException {
        return (Daughter) super.clone();
    }
}

public class ShallowClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        Father father = new Father("bigFather",49);
        Daughter daughter1 = new Daughter("Hellen", 24);
        daughter1.father = father;
        Daughter daughter2 = daughter1.clone();

        System.out.println("daughter1==daughter2: " +  (daughter1 == daughter2));
        System.out.println("daughter1.age==daughter2.age: " + (daughter1.age == daughter2.age));
        System.out.println("daughter1.father==daughter2.father: " + (daughter1.father == daughter2.father));
        System.out.println("daughter2: " + daughter2);

        daughter1.age = 12;
        daughter2.father.name = "smallFather";
        daughter1.name="ketty";
        daughter2.father.age = 67;
        System.out.println("=============================");
        System.out.println("daughter1==daughter2: " +  (daughter1 == daughter2));
        System.out.println("daughter1.father==daughter2.father: " + (daughter1.father == daughter2.father));
        System.out.println("daughter1.age==daughter2.age: " + (daughter1.age == daughter2.age));
        System.out.println("daughter1: " + daughter1);
        System.out.println("daughter2: " + daughter2);

    }

}
