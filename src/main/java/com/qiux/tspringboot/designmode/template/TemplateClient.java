package com.qiux.tspringboot.designmode.template;

import java.util.concurrent.Callable;

/**
 * @author qiux
 * @Date 2022/2/9
 * @since
 */
public class TemplateClient {
    public static void main(String[] args) {
        TeaMake teaMake = new TeaMake();
        teaMake.brew();
        CoffeeMake coffeeMake = new CoffeeMake();
        coffeeMake.brew();
    }
}
