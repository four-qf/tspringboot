package com.qiux.tspringboot.test;

import java.util.*;

/**
 * @author qiuxian
 * @date 2020/5/14
 */
public class TestCount {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(32);
        list.add(36);
        list.add(38);
        list.add(40);
        list.add(62);
        List<Integer> count = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for (Integer i : list) {
            for(Integer k : list) {
                if (k!=i) {
                    map.put(i+k, Arrays.asList(i,k));
                }
            }
        }
        System.out.println(map.get(36+30));

        for (Integer i : list) {
            for (Integer k : list) {
                if (i != k) {
                    if (map.keySet().contains((i + k)/2) && !count.contains(i+k) && !map.get((i + k)/2).contains(i) &&  !map.get((i + k)/2).contains(k) ) {
                        System.out.println("count="+count + ",i="+i + ",k=" +k);
                        return;
                    }
                    for (Integer j : list) {
                        if (k != j && !map.keySet().contains(i+k+j) && map.keySet().contains((i+k+j)/2)) {
                            if ( !map.get((i + k + j)/2).contains(i) &&  !map.get((i + k + j)/2).contains(k) && !map.get((i + k + j)/2).contains(j)) {
                                System.out.println("map="+ map.get((i + k + j)/2) + ",i="+i + ",k=" +k +",j="+j);
                                return;
                            }

                        }
                    }
                }
            }
        }

//        System.out.println(count);

    }

}
