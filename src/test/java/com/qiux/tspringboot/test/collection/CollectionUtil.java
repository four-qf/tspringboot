package com.qiux.tspringboot.test.collection;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiuxian
 * @date 2020/4/5
 */
public class CollectionUtil {

    public static void main(String[] args) {
//        Set<String> unmodifiableSet = Collections.unmodifiableSet(Sets.newHashSet("a", "b", "c", "d"));
//        System.out.println(unmodifiableSet);
////        unmodifiableSet.add("g");
////        System.out.println(unmodifiableSet);
//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"a");
//        map.put(2,"b");
//        map.put(3,"c");
//
//        map.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey());
//        });

        mergeMap();


    }

    public static void mergeMap() {
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("name","qiu");
        map.merge("name", "xian", (a, b) -> a + "test" + b);
        System.out.println(map.get("name"));
    }

}
