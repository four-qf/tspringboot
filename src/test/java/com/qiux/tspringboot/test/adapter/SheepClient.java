package com.qiux.tspringboot.test.adapter;

public class SheepClient {

    public static void main(String[] args) {
        SheepService sheepService = new SheepTurkeyServiceAdapter();
        int count = sheepService.countFootNum(4);
        System.out.println(count);
    }

}
