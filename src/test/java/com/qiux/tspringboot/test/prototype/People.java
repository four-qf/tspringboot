package com.qiux.tspringboot.test.prototype;

import com.qiux.tspringboot.test.annontationtest.City;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuxian
 * @date 2020/4/13
 */
@Setter
@Getter
@ToString
@Slf4j
public class People implements Cloneable {

    private String name;

    private int age;

    private City city;



    public static void main(String[] args) throws CloneNotSupportedException {

        People people = new People();
        people.setAge(2);
        City city = new City();
        city.setCityName("test");
        people.setCity(city);
        log.info("prototype people{}", people);
        People peopleClone = (People) people.clone();
        peopleClone.setAge(4);
        log.info("clone people:{}", peopleClone);
        city.setCityName("test2");
        log.info("prototype People.city:{}", people.getCity());
        log.info("clone People.city:{}", peopleClone.getCity());
        System.out.println(people);
    }

}
