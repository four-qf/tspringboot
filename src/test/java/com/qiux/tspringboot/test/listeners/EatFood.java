package com.qiux.tspringboot.test.listeners;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class EatFood {

    private String type;

    private Integer pNum;

    private Set<Food> foods = new HashSet<>();

    private String reason;

    private Boolean isEatFood;

}
