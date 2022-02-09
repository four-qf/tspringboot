package com.qiux.tspringboot.test.template;

/**
 * @author qiux
 * @Date 2022/2/9
 * @since
 */
public class StarBuzzBrew {

    public void brewingMethod(Drink drink) {
        System.out.println(String.format("开始烹饪%s----------",drink.getName()));
        System.out.println("1.把水煮沸");
        System.out.println(String.format("2.用沸水冲泡%s", drink.getName()));
        System.out.println(String.format("3.把%s倒进杯子", drink.getName()));
        System.out.println(String.format("4.加%s", drink.getIngredients()));
        System.out.println(String.format("烹饪%s完成----------",drink.getName()));
    }

    public static void main(String[] args) {
        Drink coffee = new Drink("咖啡", "糖和牛奶");
        StarBuzzBrew starBuzzBrew = new StarBuzzBrew();
        starBuzzBrew.brewingMethod(coffee);
        Drink tea = new Drink("茶", "柠檬");
        starBuzzBrew.brewingMethod(tea);
    }

}
