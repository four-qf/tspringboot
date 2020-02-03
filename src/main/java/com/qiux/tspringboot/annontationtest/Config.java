package com.qiux.tspringboot.annontationtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
@Slf4j
@Configuration
public class Config {

    @Bean
    public City getCity() {
        City city = new City();
        city.setCityName("千岛湖");
        return city;
    }

    @Bean
    @ConditionalOnBean(name = "city")
    public People getPeople(City city) {
        city.setCityCode(301701);
        return new People("小小", 3, city);
    }

}
