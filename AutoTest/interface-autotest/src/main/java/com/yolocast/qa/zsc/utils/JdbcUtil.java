package com.yolocast.qa.zsc.utils;

import com.yolocast.qa.zsc.Constant.Common;

import java.sql.*;

/**
 * @author zhangsc
 * @date 2022-05-06 下午3:39
 */
public class JdbcUtil {

    private static Connection conn = null;

    public static Connection getConn(){
        try{
            //获取连接对象Connection
            Class.forName(Common.driver);
            conn = DriverManager.getConnection(Common.url,Common.username,Common.password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
            close();
        }
        return conn;
    }

    public static void close(){
        try{
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
