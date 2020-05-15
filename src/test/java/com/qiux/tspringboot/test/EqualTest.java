package com.qiux.tspringboot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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

        List tab;
        List table = new ArrayList();
        table.add(1);
        table.add(3);
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.accumulateAndGet(3,(n, m)-> n+m);
        System.out.println(atomicInteger.get());


        IntStream.range(0,6).forEach(i -> {
            Runnable runnable = () -> {
              atomicInteger.accumulateAndGet(i, (n,m) -> n+m);
            };
            runnable.run();
            System.out.println("i:"+ i);
            System.out.println("result:" + atomicInteger.get());
        });
        System.out.println(atomicInteger.get());

    }

}

@Data
class User implements Serializable {

    private static final long serialVersionUID = 7489190869126238787L;
    private String name;

    private String age;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(name, user.name);
//    }

//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name);
//    }
}

