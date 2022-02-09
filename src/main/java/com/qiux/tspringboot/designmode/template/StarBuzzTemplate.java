package com.qiux.tspringboot.designmode.template;

/**
 * @author qiux
 * @Date 2022/2/9
 * @since
 */
public abstract class StarBuzzTemplate {

    public void brew() {
        prepare();
        makingDrink();
        loadDrink();
        addIngredients();
    }

    public void prepare()  {
        System.out.println("把水煮沸");
    }

    public abstract void makingDrink();

    public abstract void loadDrink();

    public abstract void addIngredients();

}

