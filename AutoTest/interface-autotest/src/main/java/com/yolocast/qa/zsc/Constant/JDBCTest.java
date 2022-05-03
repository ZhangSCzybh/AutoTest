package com.yolocast.qa.zsc.Constant;

import java.sql.*;

/**
 * @author zhangsc
 * @date 2022-04-27 下午7:55
 */
public class JDBCTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*

        //加载驱动 /Users/zhangshichao/.m2/repository/mysql/mysql-connector-java/8.0.13/mysql-connector-java-8.0.13.jar!/com/mysql/cj/jdbc/Driver.class
        Class.forName(" com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "cdb-r2n18bf9.usw.cdb.myqcloud.com:8596/yololiv";
        String name = "yololiv";
        String pwd = "Yololiv123!";
        Connection connection = DriverManager.getConnection(url, name, pwd);
        //获取statement对象
        //Statement statement = connection.createStatement();
        String sql = "SELECT * FROM org ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执行语句
        //ResultSet resultSet = statement.executeQuery(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        System.out.println(resultSet);

         */

        Connection conn = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://cdb-r2n18bf9.usw.cdb.myqcloud.com:8596/yolo_usercenter",
                    "yololiv", "Yololiv123!");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }



    }
