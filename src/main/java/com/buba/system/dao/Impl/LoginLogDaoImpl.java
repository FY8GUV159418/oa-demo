package com.buba.system.dao.Impl;

import com.buba.system.dao.LoginLogDao;
import com.buba.system.pojo.LoginLog;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LoginLogDaoImpl implements LoginLogDao {
    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());

    /**
     * 查询登录日志
     *
     * @param param
     * @return
     */
    @Override
    public List<LoginLog> selLog(Map<String, String> param) {
        String sql = "select ln.*,s.UserName from userinfo as s right join loginlog as ln on s.UserId = ln.UserId";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(LoginLog.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}