package com.qiux.tspringboot.test.reflect;

import com.qiux.tspringboot.test.annontationtest.City;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
public class  LostInformationTest<T> {

    public LostInformationTest<City> getInstance() {
        LostInformationTest<City> lostInformationTest = new LostInformationTest<>();
        System.out.println("3:"+Arrays.toString(lostInformationTest.getClass().getTypeParameters()));
        return lostInformationTest;
    }

    public static void main(String[] args) {
        LostInformationTest lostInformationTest = new LostInformationTest();
        lostInformationTest = lostInformationTest.getInstance();
        System.out.println("1:"+ lostInformationTest);
        System.out.println("2:" + Arrays.toString(lostInformationTest.getClass().getTypeParameters()));
    }

}
