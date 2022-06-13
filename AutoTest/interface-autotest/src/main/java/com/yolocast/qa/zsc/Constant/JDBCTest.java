package com.yolocast.qa.zsc.Constant;

import com.yolocast.qa.zsc.utils.JdbcUtil;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * @author zhangsc
 * @date 2022-04-27 下午7:55
 */
public class JDBCTest {

    @Test
    public void jdbc() throws SQLException {
        Connection conn = JdbcUtil.getConn();

        try{
            Statement stat = conn.createStatement();
            //不自动提交
            conn.setAutoCommit(false);

            //String sql_update = " insert into user (name,age) values(\"张三\",100) ";
            //stat.executeUpdate(sql_update);
            String sql_selete = " SELECT * FROM activity WHERE activity_id = 901289873992847360 ";
            ResultSet re = stat.executeQuery(sql_selete);

            while(re.next()){
                String title = re.getString("title");
                System.out.println(title);
            }
           // conn.commit(); //提交
            JdbcUtil.close();
        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }

    }

    }
