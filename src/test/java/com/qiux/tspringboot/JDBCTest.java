package com.qiux.tspringboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("test");
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://162.14.67.209:3306/auth_center_admin","root","123456");
        //jdbc预编译
        long startTime = System.currentTimeMillis();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username, password) values(?,?)");
//        //设置sql占位值
//        preparedStatement.setString(1, "ky2");
//        preparedStatement.setString(2, "99");
        //获取值
//        int rows1 = preparedStatement.executeUpdate();
//        System.out.println(rows1);

        preparedStatement.setString(1, "hz");
        preparedStatement.setString(2, "22");
        int rows2 = preparedStatement.executeUpdate();


        long endTime = System.currentTimeMillis();
        System.out.println(rows2 + ":" + (endTime-startTime));

        preparedStatement.close();
        connection.close();

    }
}
