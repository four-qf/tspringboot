package com.qiux.tspringboot.test.transactiontest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author qiuxian
 * @date 2020/3/5
 */
@Slf4j
//@SpringBootApplication
public class ProgrammicTransactionDemoApplication implements CommandLineRunner {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public static void main(String[] args) {
//        SpringApplication.run(ProgrammicTransactionDemoApplication.class);
//    }

    @Override
    public void run(String... args) throws Exception {
        log.info("COUNT BEFORE TRANSACTION: {}", getCount());
//        transactionTemplate.execute(new TransactionCallbackWithoutResult(){
//
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                jdbcTemplate.execute("INSERT INTO student (name, age, phone, email, grade) VALUES ('abc', 23,'16601364175','qiu166036@gmail.com','本科')");
//                log.info("COUNT IN TRANSACTION: {}", getCount());
//                transactionStatus.setRollbackOnly();
//            }
//        });
//        log.info("COUNT AFTER TRANSACTION: {}", getCount());

        long count = transactionTemplate.execute(new TransactionCallback<Long>() {
            @Override
            public Long doInTransaction(TransactionStatus transactionStatus) {
                jdbcTemplate.execute("INSERT INTO student (name, age, phone, email, grade) VALUES ('abc', 25,'16601364175','qiu166036@gmail.com','本科')");

                log.info("COUNT IN callback TRANSACTION: {}", getCount());
//                transactionStatus.setRollbackOnly();
                return getCount();
            }
        });

        log.info("COUNT AFTER CallBack TRANSACTION : {}",count);
        log.info("COUNT AFTER CallBack TRANSACTION : {}",getCount());

    }

    public long getCount(){
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM student  ").get(0).get("CNT");
    }
}
