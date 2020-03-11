package com.qiux.tspringboot.test.annontationtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
@Slf4j
//@SpringBootApplication
public class ConditionalOnBeanApplication implements CommandLineRunner {

    @Autowired(required = false)
    private People people;

//    public static void main(String[] args) {
//        SpringApplication.run(ConditionalOnBeanApplication.class);
//    }

    @Override
    public void run(String... args) throws Exception {

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info("people = " + people);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
}
