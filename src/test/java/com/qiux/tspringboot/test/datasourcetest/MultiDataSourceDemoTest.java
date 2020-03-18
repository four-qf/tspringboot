package com.qiux.tspringboot.test.datasourcetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author qiuxian
 * @date 2020/2/2
 */
@Slf4j
//@EnableAutoConfiguration(exclude={
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        JdbcTemplateAutoConfiguration.class
//})
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class MultiDataSourceDemoTest implements InitializingBean {

    @Resource(name = "testTxManager")
    private PlatformTransactionManager testTxManager;

    @Resource(name = "userTxManager")
    private PlatformTransactionManager userTxManager;

    @Resource(name = "userDataSource")
    private DataSource userDataSource;

    @Resource(name = "testDataSource")
    private DataSource testDataSource;

    private JdbcTemplate testJdbcTemplate;

    private JdbcTemplate userJdbcTemplate;

    @Override
    public void afterPropertiesSet() {
        userJdbcTemplate = new JdbcTemplate(userDataSource);
        testJdbcTemplate = new JdbcTemplate(testDataSource);
    }

    private void showUserConnection() throws SQLException {
        log.info(userDataSource.toString());
        Connection conn = userDataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showTestConnection() throws SQLException {
        log.info(testDataSource.toString());
        Connection connection = testDataSource.getConnection();
        log.info(connection.toString());
        connection.close();

    }

    @Transactional("userTxManager")
    public void showUserData() {
        userJdbcTemplate.queryForList("SELECT * FROM student")
                .forEach(student -> log.info(student.toString()));
    }

    @Transactional("testTxManager")
    public void showTestData() {
        testJdbcTemplate.queryForList("SELECT * FROM user")
                .forEach(user -> log.info(user.toString()));
    }

    @Test
    public void testMultiDataSource() throws Exception {
        log.info("test connection start -----------------------------");
        showTestConnection();
        log.info("test connection end -------------------------------");

        log.info("user connection start -------------------------------");
        showUserConnection();
        log.info("user connection end -------------------------------");

        log.info("showUserData------------------");
        showUserData();

        log.info("showTestData------------------");
        showTestData();

    }


}
