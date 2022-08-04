package com.qiux.tspringboot.effective_java.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author qiux
 * @Date 2022/8/4
 * @since
 */
@AllArgsConstructor
@Data
class Person implements Comparable {

    private String name;

    private int age;

    private int weight;

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        int i = age - person.age;
        if (i !=0) {
            return i;
        }
        return weight - person.weight;
    }

}

public class ComparableTest {

    public static void main(String[] args) {

        List<Person> ps = new ArrayList<>();
        ps.add(new Person("张三", 32, 48));
        ps.add(new Person("李四", 29, 47));
        ps.add(new Person("王五", 29, 46));

        System.out.println(ps);
        Collections.sort(ps);
        System.out.println(ps);

    }


}
