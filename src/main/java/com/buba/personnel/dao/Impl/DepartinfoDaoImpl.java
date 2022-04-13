package com.buba.personnel.dao.Impl;

import com.buba.personnel.dao.DepartinfoDao;
import com.buba.personnel.pojo.Departinfo;
import com.buba.utils.DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DepartinfoDaoImpl implements DepartinfoDao {

    QueryRunner queryRunner = new QueryRunner(DBPool.getDS());
    @Override
    public void addDepartinfo(Map<String, String> map) {
        //编写sql 语言
        String sql = "insert into departinfo values(null,?,?,?,?,?)";
        //执行sql
        Object[] o = new Object[5];
        //从map中取得值一定要和前端列表的name值一致
        o[0] = map.get("departName");
        o[1] = map.get("principalUser");
        o[2] = map.get("connectTeNo");
        o[3] = map.get("connectMobileTelNo");
        o[4] = map.get("faxes");
        try {
            queryRunner.update(sql,o);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Departinfo> selDp() {
        String sql = "select * from departinfo";
        try {
            return queryRunner.query(sql, new BeanListHandler<Departinfo>(Departinfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int upDp(String ids) {
        String sql = "delete from departInfo where departId in ("+ids+")";
        try {
            return queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
