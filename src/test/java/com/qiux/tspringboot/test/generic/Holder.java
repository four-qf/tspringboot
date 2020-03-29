package com.qiux.tspringboot.test.generic;

import java.util.List;
import java.util.Objects;

/**
 * @author qiuxian
 * @date 2020/3/19
 */
public class Holder<T> {

    private T value;

    public Holder(T value) {
        this.value = value;
    }

    public Holder() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return o.equals(value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    public Object show(List<T> list) {
        return list.get(0);
    }

    public Object showOne(List<?> list) {
        return list.get(0);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        System.out.println("appleHolder:" + appleHolder);
        Apple apple = appleHolder.getValue();
        System.out.println("apple:" + apple);
        Holder<? extends Fruit> fruitHolder = appleHolder;
        System.out.println("fruitHolder:" + fruitHolder);
        Fruit fruit = fruitHolder.getValue();
        System.out.println(fruitHolder.equals(apple));
        apple = (Apple) fruitHolder.getValue();
        System.out.println(apple);
        System.out.println(fruitHolder.equals(apple));

    }

}

class Fruit {
}

class Apple extends Fruit{

}
