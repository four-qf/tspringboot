package com.qiux.tspringboot.test.collection;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Set;

/**
 * @author qiuxian
 * @date 2020/4/5
 */
public class CollectionUtil {

    public static void main(String[] args) {
        Set<String> unmodifiableSet = Collections.unmodifiableSet(Sets.newHashSet("a", "b", "c", "d"));
        System.out.println(unmodifiableSet);
//        unmodifiableSet.add("g");
//        System.out.println(unmodifiableSet);
    }

}
