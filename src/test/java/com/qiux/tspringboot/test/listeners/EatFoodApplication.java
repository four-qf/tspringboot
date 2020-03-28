package com.qiux.tspringboot.test.listeners;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static com.qiux.tspringboot.test.listeners.EatFoodEnum.LUNCH;
import static com.qiux.tspringboot.test.listeners.EatFoodEnum.SNACKS;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EatFoodApplication {

    @Test
    public void testEatFoodListener() {

        EatFoodListener eatFoodListener = new EatFoodListener();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //一般来说吃东西应该会根据时间来，不可能每时每刻都问需要不需要吃东西的。
                // 这么做：一来呢这只是个测试用例，二来呢时间也不允许这么等，再说一个测试用例你弄那么复杂你要上天啊
                EatFoodEnum[] eatFoodEnums = EatFoodEnum.values();
                for (Enum eatFoodEnum : eatFoodEnums) {
                    EatFood eatFood = new EatFood();
                    if (eatFoodEnum.equals(SNACKS)) {
                        eatFood.setIsEatFood(true);
                    }
                    if (eatFoodEnum.equals(LUNCH)) {
                        eatFood.setPNum(2);
                        eatFood.setIsEatFood(false);
                        Food food = new Food();
                        food.setName("牛排");
                        food.setCount(2);
                        food.setWeight(500);
                        HashSet foods = new HashSet<>();
                        foods.add(food);

                        eatFood.setType(eatFoodEnum.name());
                        eatFood.setFoods(foods);
                    }
                    log.info("我可以吃东西了吗？");
                    eatFoodListener.onApplicationEvent(new EatFoodEvent(eatFood));
                    System.out.println();
                }

            }
        });

        thread.start();

    }
}