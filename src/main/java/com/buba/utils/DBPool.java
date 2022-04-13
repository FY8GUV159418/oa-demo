package com.buba.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.beans.PropertyVetoException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

/**
 * c3p0是数据库连接池工具包
 * @author 杨柳
 * @date 2018年5月25日下午2:13:05
 */
public class DBPool {
    //当前类
    private static DBPool dbPool;
    //数据源
    private DruidDataSource dataSource;
    //初始化类

    /**
     * 静态代码块，在加载类时执行，而且只会执行一次
     */
    static {
        dbPool=new DBPool();
    }

    /**
     * 私有化构造器，不允许在该类外面创建对象
     * 因为一个系统只需要一个数据库连接池
     */
    //设置c3p0连接池的参数
    private DBPool() {
        //创建链接池
        dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ov?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }
    //提供一个公开数据源
    public final static DataSource getDS() {
        return dbPool.dataSource;
    }
}
