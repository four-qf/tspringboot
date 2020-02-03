package com.qiux.tspringboot.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qiuxian
 * @date 2020/2/3
 */
@Slf4j
@SpringBootApplication
public class DruidDataSourceApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DruidDataSourceApplication.class,args);
    }

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

    @Override
    public void run(String... args) throws Exception {
        showDruibConnection();
        showUserData();
    }

}
