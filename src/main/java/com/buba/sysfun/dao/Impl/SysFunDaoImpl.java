package com.buba.sysfun.dao.Impl;

import com.buba.login.pojo.UserInfo;
import com.buba.sysfun.dao.SysFunDao;
import com.buba.sysfun.pojo.SysFun;
import com.buba.sysfun.pojo.SysFunS;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SysFunDaoImpl implements SysFunDao {

    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());


    @Override
    public List<SysFun> selectRole(Map<String, String> param) {
        String sql = "select * from roleinfo r, roleright rr,sysfun s where r.RoleId=rr.RoleId and s.nodeid = rr.NodeId and r.roleId=" + param.get("roleId");
        try {
            return queryRunner.query(sql,new BeanListHandler<SysFun>(SysFun.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysFunS> SysfunAll() {
        String sql = "select NodeId id,DisplayName name,ParentNodeId pId from sysfun";
        try {
            return queryRunner.query(sql,new BeanListHandler<SysFunS>(SysFunS.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysFun> selSysfun(UserInfo user) {
        String sql = "select * from roleinfo r, roleright rr,sysfun s where r.RoleId=rr.RoleId and s.nodeid = rr.NodeId and r.roleId=?";
        try {
            return queryRunner.query(sql, new BeanListHandler<SysFun>(SysFun.class), user.getRoleId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
