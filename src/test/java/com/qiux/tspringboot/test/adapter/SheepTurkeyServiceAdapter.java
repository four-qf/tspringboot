package com.qiux.tspringboot.test.adapter;

public class SheepTurkeyServiceAdapter implements SheepService{

    int sheepNum = 2;
    private TurkeyService turkeyService ;
    private SheepService sheepService = new SheepServiceImpl();

    @Override
    public void quack() {
        sheepService.quack();
    }

    @Override
    public void fly() {
        sheepService.fly();
    }

    public int countFootNum(int num) {
        if (num < sheepNum) {
            return sheepService.countFootNum(num);
        }
        int turkeyNum = num - sheepNum;
        turkeyService = new TurkeyServiceImpl();
        return sheepService.countFootNum(sheepNum) + turkeyService.footNum(turkeyNum);
    }

}
