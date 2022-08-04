package com.qiux.tspringboot.effective_java.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiux
 * @Date 2022/8/4
 * @since
 */
@Data
@AllArgsConstructor
class Student {

    private String name;

    private int age;

}

class StudentComparetor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class ComparatorTest {

    public static void main(String[] args) {

        List<Student> ss = new ArrayList<>();
        ss.add(new Student("Marry", 24));
        ss.add(new Student("Jerry", 17));
        ss.add(new Student("Ketty", 27));

        System.out.println(ss);
        Collections.sort(ss, new StudentComparetor());
        System.out.println(ss);

    }

}
