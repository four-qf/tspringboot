package com.qiux.tspringboot.test.datasourcetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qiuxian
 * @date 2020/2/3
 */
@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class DruidDataSourceApplication {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void showDruibConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();

    }

    public void showUserData() {
        jdbcTemplate.queryForList("SELECT * FROM student")
                .forEach(student -> log.info(student.toString()));
    }

    @Test
    public void druibConnectTest() throws Exception {
        showDruibConnection();
        showUserData();
    }

}
