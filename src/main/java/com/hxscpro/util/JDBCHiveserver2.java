package com.hxscpro.util;

import org.springframework.stereotype.Service;

import java.sql.*;

/**
 * @author hx
 * @version 1.0
 * @date 2021/1/20 14:11
 */
@Service
public class JDBCHiveserver2 {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://172.30.101.201:10000/dl";

    private static Connection con = null;
    private static Statement state = null;
    private static ResultSet res = null;

    //加载驱动,创建连接
    public Statement init() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        con = DriverManager.getConnection(url, "xx", "xx");
        state = con.createStatement();
        return state;
    }

/*    public void showtDb() throws SQLException {
        res = state.executeQuery("show databases");
        while (res.next()) {
            System.out.println(res.getString(1));
        }
    }*/

    public static void main(String[] args) {

//        JDBCHiveserver2 hice = new JDBCHiveserver2();
//
//        try {
//            hice.init();
//            hice.showtDb();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
}
