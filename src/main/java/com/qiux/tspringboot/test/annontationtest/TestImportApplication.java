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
public class TestImportApplication implements CommandLineRunner {

    @Autowired
    private PeopleService peopleService;

//    public static void main(String[] args) {
//        SpringApplication.run(TestImportApplication.class);
//    }

    @Override
    public void run(String... args) throws Exception {
        log.info("importPeopleTest>>>>>>" + peopleService.getAge());
    }
}
