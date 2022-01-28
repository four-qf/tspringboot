package com.qiux.tspringboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1.获取数据源
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://162.14.67.209:3306/auth_center_admin");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2.加载mybatis连接配置
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(UserMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
//        User user = (User) session.selectOne("com.qiux.tspringboot.UserMapper.selectByPrimaryKey", 1);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}
