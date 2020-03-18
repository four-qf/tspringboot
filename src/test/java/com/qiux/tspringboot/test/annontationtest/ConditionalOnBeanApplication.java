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
public class ConditionalOnBeanApplication {

    @Autowired(required = false)
    private People people;

    @Test
    public void testPeople() throws Exception {

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info("people = " + people);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
}
