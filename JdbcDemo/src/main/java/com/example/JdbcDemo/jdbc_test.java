package com.example.JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库连接URL以及相关配置
        String url = "jdbc:mysql://10.1.10.201:3306/test?autoDeserialize=true&queryInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=deser_CC31_calc";
        //加载驱动类
        Class.forName(driver);
        //通过 Drivermanager 类获取数据库连接的实例
        Connection connection = DriverManager.getConnection(url);
    }
}
