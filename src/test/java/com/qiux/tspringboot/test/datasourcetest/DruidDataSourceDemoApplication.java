package com.qiux.tspringboot.test.datasourcetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author qiuxian
 * @date 2020/2/3
 */
@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class DruidDataSourceDemoApplication{

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource(){
        log.info(dataSource.toString());
    }

}
