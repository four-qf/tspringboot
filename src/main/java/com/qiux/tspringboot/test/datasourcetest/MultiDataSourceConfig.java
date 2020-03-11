package com.qiux.tspringboot.test.datasourcetest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author qiuxian
 * @date 2020/2/2
 */
@Slf4j
//@Configuration
public class MultiDataSourceConfig {

    @Bean
    @ConfigurationProperties("user.datasource")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource userDataSource() {
        DataSourceProperties dataSourceProperties = userDataSourceProperties();
        log.info("foo datasource: {}", dataSourceProperties);
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager userTxManager(DataSource testDataSource) {
        return new DataSourceTransactionManager(testDataSource);
    }


    @Bean
    @Primary
    @ConfigurationProperties("test.datasource")
    public DataSourceProperties testDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource testDataSource() {
        DataSourceProperties dataSourceProperties = testDataSourceProperties();
        log.info("foo datasource: {}", dataSourceProperties);
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    @Resource
    public PlatformTransactionManager testTxManager(DataSource testDataSource) {
        return new DataSourceTransactionManager(testDataSource);
    }

}
