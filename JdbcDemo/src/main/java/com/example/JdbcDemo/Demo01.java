package com.example.JdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        Statement st = null;
        PreparedStatement ppst = null;
        Connection con =null;
        try {
            //1、加载mysql数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、创建数据库连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","zzz@2160");
            //3、创建statement，用于执行sql语句
//            st = con.createStatement();
//            ppst = con.prepareStatement("select * from user where name='"+name+"' and passwd='"+password+"'");
            ppst = con.prepareStatement("select * from user where name=? and passwd=?");
            //对?号进行传参，1代表第一个?，2代表第二个?，依次类推。
            ppst.setString(1,name);
            ppst.setString(2,password);
            //4、执行sql语句，查询并判断用户名、口令是否正确
//            ResultSet rs = st.executeQuery("select * from user where name='"+name+"' and passwd='"+password+"'");
            ResultSet rs = ppst.executeQuery();
            if (rs.next()){
                System.out.println("登录成功！！");
            }else {
                System.out.println("用户名或者密码错误！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
