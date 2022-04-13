package com.buba.sysfun.dao.Impl;

import com.buba.sysfun.dao.SysfunDao;
import com.buba.sysfun.pojo.Sysfun;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SysfunDaoImpl implements SysfunDao {

    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());

    @Override
    public List<Sysfun> selSysfun() {
        //编写sql 语句
        String sql = "select * from sysfun";
        //执行sql 语句
        try {
           return queryRunner.query(sql,new BeanListHandler<Sysfun>(Sysfun.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
