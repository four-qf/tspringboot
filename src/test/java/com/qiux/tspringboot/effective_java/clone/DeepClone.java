package com.qiux.tspringboot.effective_java.clone;

/**
 * @author qiux
 * @Date 2022/8/1
 * @since 深拷贝：在对引用类型进行拷贝的时候，会创建一个新对象，并且复制其成员变量
 *        实现方式：1.实现clone(缺点：对象层级太多，需要逐一进行拷贝太繁琐)；2.序列化
 *
 */
class Teather implements Cloneable{

    String name;

    int age;

    @Override
    protected Teather clone() throws CloneNotSupportedException {
        return (Teather) super.clone();
    }

    public Teather(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teather{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class  Student implements Cloneable {

    String name;

    int age;

    Teather teather;

    public Student(String name, int age, Teather teather) {
        this.name = name;
        this.age = age;
        this.teather = teather;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.teather = teather.clone();
        return s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teather=" + teather +
                '}';
    }
}

public class DeepClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        Teather teather = new Teather("小王", 40);
        Student student1 = new Student("七七", 14, teather);

        Student student2 = student1.clone();

        System.out.println("student1==student2:   " + (student1 == student2));
        System.out.println("student1:" + student1);
        System.out.println("student2:" + student2);

        System.out.println("============================================");

        student1.name = "飞飞";
        student1.age = 11;
        student1.teather.name="Bob";
        student2.teather.age=50;

        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);

    }

}
