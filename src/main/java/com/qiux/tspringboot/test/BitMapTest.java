package com.qiux.tspringboot.test;

import java.util.BitSet;

/**
 * @author qiux
 * @Date 2022/3/19
 * @since
 */
public class BitMapTest {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1,true);
        bitSet.set(3,true);
        bitSet.set(9,false);
        bitSet.set(6,false);

        System.out.println(bitSet.toString());
        System.out.println(bitSet.cardinality());
    }

}
