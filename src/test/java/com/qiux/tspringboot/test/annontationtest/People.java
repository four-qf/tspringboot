package com.qiux.tspringboot.test.annontationtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {

    private String name;

    private Integer age;

    private City city;

}
