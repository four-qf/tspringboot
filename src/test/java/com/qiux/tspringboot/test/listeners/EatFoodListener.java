package com.qiux.tspringboot.test.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import static com.qiux.tspringboot.test.listeners.EatFoodEnum.SNACKS;

@Slf4j
public class EatFoodListener {

    public void onApplicationEvent(EatFoodEvent eatFoodEvent) {
       EatFood eatFood = (EatFood) eatFoodEvent.getSource();
       if (eatFood.getType().equals(SNACKS.name()) && eatFood.getIsEatFood()) {
           log.info("警告：你已经吃过东西了哦，再吃零食会长胖的呀！！");

       }else if (!eatFood.getType().equals(SNACKS.name()) && !eatFood.getIsEatFood() && eatFood.getPNum()<10
               && !CollectionUtils.isEmpty(eatFood.getFoods())) {
           log.info("吃饭啦吃饭啦，开心ing*_(，今天居然有这么多好吃的：{},但是不要多吃哦,要控制要控制。",eatFood.getFoods());

       } else {
           log.info("天天就想吃东西，胖死你算了。减肥减肥减肥减肥，重要的事说三遍！！！");
       }
    }
}
