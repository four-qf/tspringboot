package com.qiux.tspringboot.test.listeners;

import org.springframework.context.ApplicationEvent;

public class EatFoodEvent extends ApplicationEvent {


    /**
     * Constructs a prototypical Event.
     *
     * @param eatFood The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EatFoodEvent(EatFood eatFood) {
        super(eatFood);
    }
}
