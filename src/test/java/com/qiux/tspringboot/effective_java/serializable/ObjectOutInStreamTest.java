package com.qiux.tspringboot.effective_java.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author qiux
 * @Date 2022/8/8
 * @since
 * 在检测序列化类型为ObjectStreamClass后，
 * 在ObjectStreamClass.ObjectStreamClass(final Class<?> cl)中，
 * 会通过反射检测序列化或反序列化的类中编写是否有private void writeObject(ObjectOutputStream oos)或private void readObject(ObjectInputStream ois)，
 * 如果有将通过该类中的这两个方法进行序列化或者反序列化
 */
@AllArgsConstructor
@Data
class Person implements Serializable {

    private String name;

    private int age;

    // 0 女孩 1 男孩
    private int sex;

    private int weight;

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(name);
        oos.writeInt(age);
        oos.writeInt(sex);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.name = (String) ois.readObject();
        age = ois.readInt();
        sex = ois.readInt();
    }

}

public class ObjectOutInStreamTest {

    public static void main(String[] args) {

        Person person = new Person("Hellen", 29, 1, 67);
        System.out.println(person);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Person.obj"));
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Person.obj"));
            Person person1 = (Person) ois.readObject();
            System.out.println(person1);
            System.out.println(person == person1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
