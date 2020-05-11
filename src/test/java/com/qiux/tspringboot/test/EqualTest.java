package com.qiux.tspringboot.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author qiuxian
 * @date 2020/5/4
 */
//@Slf4j
public class EqualTest {


    public static void main(String[] args) {
//        User user1 = new User("test1");
//        User user2 = new User("test1");
//        log.info("user1 == user2:{}", user1 == user2);
//        log.info("user1.equal(user2):{} ", user1.equals(user2));
//        StringBuffer stringBuffer = new StringBuffer();

//        List tab;
//        List table = new ArrayList();
//        table.add(1);
//        table.add(3);
//        int n=2;
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

    }

}

//@Data
class User {

    private String name;

    private String age;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name);
//    }
}

