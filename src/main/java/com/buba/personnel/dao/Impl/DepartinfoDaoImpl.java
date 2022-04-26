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

    /**
     * 添加
     * @param map
     */
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

    /**
     * 查询
     * @return
     */
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

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public int delup(String ids) {
            String sql = "delete from departInfo where departId in ('"+ids+"')";
            try {
                return queryRunner.update(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return 0;
    }

    /**
     * 修改
     * @param param
     * @return
     */
    @Override
    public int upDp(Map<String, String> param) {
        String sql1 = "update departinfo set departName=?,principalUser=?,ConnectTeNo=?,connectMobileTelNo=?,faxes=? where departId=?";
        Object[] obj = new Object[6];
        obj[0] = param.get("departName");
        obj[1] = param.get("principalUser");
        obj[2] = param.get("connectTeNo");
        obj[3] = param.get("connectMobileTelNo");
        obj[4] = param.get("faxes");
        obj[5] = param.get("departId");

        try {
            return queryRunner.update(sql1,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
