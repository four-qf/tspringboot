package com.qiux.tspringboot.test.datasourcetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author qiuxian
 * @date 2020/3/19
 */
@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@EnableAutoConfiguration(exclude={
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        JdbcTemplateAutoConfiguration.class
//})
public class MultiDataSourceConfigTest {

    @Resource(name = "userDataSource")
    private DataSource userDataSource;

    @Test
    public void testConfigBean() {
        log.info("testDataSourceConfigBean" + userDataSource);
    }

}
