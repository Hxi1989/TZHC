package com.hxscpro.service;

import java.sql.SQLException;

/**
 * @author hx
 * @version 1.0
 * @date 2021/1/21 10:13
 */
public interface HiveService {

    //创建数据库
    public void CreateDb() throws SQLException, ClassNotFoundException;

    // 删除数据库
    public void dropDb() throws SQLException, ClassNotFoundException;

    // 查询所有数据库
    public void showtDb() throws SQLException, ClassNotFoundException;

}
