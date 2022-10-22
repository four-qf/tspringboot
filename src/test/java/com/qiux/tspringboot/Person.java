package com.qiux.tspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    @Override
    public String toString() {

        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}

class Product implements Comparator {
    public int price;
    public int h;
    public int q;

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
