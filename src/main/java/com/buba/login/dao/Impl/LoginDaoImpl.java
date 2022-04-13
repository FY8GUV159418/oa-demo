package com.buba.login.dao.Impl;

import com.buba.login.dao.LoginDao;
import com.buba.login.pojo.UserInfo;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Map;

public class LoginDaoImpl implements LoginDao {
    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());
    @Override
    public UserInfo login(Map<String, String> param) {
        String sql = "select * from userinfo where UserName=? and PassWord=?";
        try {
           return queryRunner.query(sql,new BeanHandler<UserInfo>(UserInfo.class),
                   param.get("UserName"),param.get("PassWord"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
