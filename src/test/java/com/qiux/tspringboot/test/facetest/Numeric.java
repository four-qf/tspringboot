package com.qiux.tspringboot.test.facetest;

import com.google.common.collect.Lists;
import com.qiux.tspringboot.test.collection.CollectionUtil;
import org.mockito.internal.util.collections.Sets;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author qiuxian
 * @date 2020/5/26
 */
public class Numeric {

    public static void main(String[] args) {

        Set set = Sets.newSet(1, 3, 6, 5, 19, 20,23,30);
        Numeric numeric = new Numeric();
        numeric.cal(set);

    }

    public void cal(Set set) {

        if (CollectionUtils.isEmpty(set) && set.size() % 2 != 0) {
            System.out.println("请输入偶数个数");
            return;
        }

        List<Integer> list = Lists.reverse((List) set.stream().sorted().collect(Collectors.toList()));
        List<Integer> reList = new ArrayList();
        List removeList = new ArrayList();
        int reSum = 0;
        int removeSum = 0;

        Iterator<Integer> it = list.listIterator();
        int count = 0;

        Integer reInt;
        Integer removeInt;
        while (it.hasNext()) {
            if (count == 0) {
                reInt = it.next();
                reSum += reInt;
                reList.add(reInt);
                removeInt = it.next();
                removeSum += removeInt;
                removeList.add(removeInt);
                list.remove(reInt);
                list.remove(removeInt);
                count++;
            }
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            int sub = reSum - removeSum;
            Integer lastInt = list.get(list.size() - 1);
            Integer smallNumCal;
            if (sub >= 0) {
                reList.add(lastInt);
                list.remove(lastInt);
                reSum += lastInt;
                sub = reSum - removeSum;
                smallNumCal = smallNumCal(list, removeList, sub);
                removeSum += smallNumCal;
            } else {
                removeList.add(lastInt);
                list.remove(lastInt);
                removeSum += lastInt;
                sub = removeSum - reSum;
                smallNumCal = smallNumCal(list, reList, sub);
                reSum += smallNumCal;
            }

            list.remove(smallNumCal);

        }

        System.out.println(list);
        System.out.println(reList);
        System.out.println(removeList);
        System.out.println(removeSum - reSum);



    }

    private Integer smallNumCal(List<Integer> list, List smallList, int sub) {
        Integer temp = list.get(0);
        int tempSub = 0;
        for (Integer n : list) {
            if (n - sub <= 0) {
                smallList.add(n);
                temp = n;
                return temp;
            }
            if ((n - sub > tempSub && tempSub == 0) || ((n - sub) < tempSub && tempSub > 0)) {
                tempSub = n - sub;
                temp = n;
            }
        }
        smallList.add(temp);
        return temp;
    }


}
