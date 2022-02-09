package com.qiux.tspringboot.designmode.template;

/**
 * @author qiux
 * @Date 2022/2/9
 * @since
 */
public class CoffeeMake extends StarBuzzTemplate{
    @Override
    public void makingDrink() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    public void loadDrink() {
        System.out.println("把咖啡倒进杯子");
    }

    @Override
    public void addIngredients() {
        System.out.println("加糖和牛奶");
    }
}
