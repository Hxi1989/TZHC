package com.hxscpro.service.impl;

import com.hxscpro.service.HiveService;
import com.hxscpro.util.JDBCHiveserver2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hive操作内容
 * @author hx
 * @version 1.0
 * @date 2021/1/21 10:30
 */
@Service
public class HiveServiceImpl implements HiveService {

    private static ResultSet res = null;

    @Resource
    private JDBCHiveserver2 jdbcHiveserver;

    //创建数据库
    public void CreateDb() throws ClassNotFoundException,SQLException {
//        jdbcHiveserver.init().execute("create database xavierdb1");
    }

    // 删除数据库
    public void dropDb() throws SQLException, ClassNotFoundException {
//        jdbcHiveserver.init().execute("drop database if exists xavierdb1");
    }

    // 查询所有数据库
    public void showtDb() throws ClassNotFoundException,SQLException {
        res = jdbcHiveserver.init().executeQuery("show databases");
//        res.last();
//        System.out.println(res.getRow());
//        res.beforeFirst();
        int i=0;
        while (res.next()) {

            System.out.println(res.getString(1));
            System.out.println(i++);

        }
    }


}
