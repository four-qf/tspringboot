package com.qiux.tspringboot.annontationtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String cityName;

    private Integer cityCode;

}
