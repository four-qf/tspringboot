package com.qiux.tspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student  {
    private Integer age;

    private String name;
//    public Student(String name) {
//        super(name);
//    }
//
//    public Student(String name, Integer age) {
//        super(name);
//        this.age = age;
//    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "age=" + age +
//                '}';
//    }
    //    @Override
//    public String toString() {
//        return "Student{" +
//                "age=" + age +
//                ",name=" + getName() +
//                '}';
//    }
}
