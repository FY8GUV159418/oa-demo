package com.buba.personnel.dao.Impl;

import com.buba.personnel.dao.StaffDao;
import com.buba.personnel.pojo.Pagination;
import com.buba.personnel.pojo.Staff;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StaffDaoImpl implements StaffDao {
    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());

    /**
     * 添加
     * @param param
     */
    @Override
    public void addStaff(Map<String, String> param) {
        // 编写sql语言
        String sql = "insert into userinfo values(?,?,?,?,?,?,1)";
        //执行sql
        Object[] obj = new Object[6];
        //从map值从map中取得值一定要和前端列表的name值一致
        obj[0] = param.get("userId");
        obj[1] = param.get("userName");
        obj[2] = param.get("password");
        obj[3] = param.get("departId");
        obj[4] = param.get("gender");
        obj[5] = param.get("roleId");
        try {
            queryRunner.update(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public int delStaff(String ids) {
        String sql = "delete from userinfo where userId in ("+ids+")";
        try {
           return queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int upStaff(Map<String, String> param) {
        //编写sql
        String sql1 ="update userinfo set userName=?,password=?,departId=?,gender=?,roleId=?,userState=? where userId=?";
        Object[] o = new Object[7];
        o[0] = param.get("userName");
        o[1] = param.get("password");
        o[2] = param.get("departId");
        o[3] = param.get("gender");
        o[4] = param.get("roleId");
        o[5] = param.get("userState");
        o[6] = param.get("userId");

        try {
           return queryRunner.update(sql1,o);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询员工页面
     * @param pagination 工具类中携带了查询条件和分页数据
     * @return
     */
    @Override
    public long selCount(Pagination<Staff> pagination) {
        String sql = "select count(*) from userinfo as ui inner join departinfo as dp on ui.departId = dp.departId where 1=1 ";
        String sql2 = condition(sql,pagination.getParam());
        try {
           return queryRunner.query(sql2,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询员工页面
     * @param pagination  工具类中携带了查询条件和分页数据
     * @return
     */
    @Override
    public List<Staff> selStaff(Pagination<Staff> pagination) {
        String sql = "select * from userinfo as ui inner join departinfo as dp on ui.departId = dp.departId inner join" +
                " roleInfo as ri on ui.roleId = ri.roleId " +
                " where 1=1 ";
        String sql2 = condition(sql,pagination.getParam());
        //添加分页 省略了计算起始下标的步骤，因为在Pagination工具类已经完成了
        sql2 += "limit " + pagination.getIndex() + "," + pagination.getLimit();
        try {
           return queryRunner.query(sql2,new BeanListHandler<Staff>(Staff.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String condition(String sql, Map<String, String> param) {
        String userName = param.get("userName");
        if (!userName.equals("") && userName != null){
            sql += " and ui.userName = '" + userName +"'";
        }
        String departName = param.get("departName");
        if (!departName.equals("") && departName != null){
            sql += " and dp.departName = '"+ departName  +"'";
        }
        return sql;
    }
}
