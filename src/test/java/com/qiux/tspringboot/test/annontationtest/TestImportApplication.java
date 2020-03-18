package com.qiux.tspringboot.test.annontationtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestImportApplication {

    @Autowired
    private PeopleService peopleService;

    @Test
    public void importPeopleTest() {
        log.info("importPeopleTest>>>>>>" + peopleService.getAge());
    }
}
