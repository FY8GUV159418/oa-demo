package com.buba.personnel.service.Impl;

import com.buba.personnel.dao.DepartinfoDao;
import com.buba.personnel.dao.Impl.DepartinfoDaoImpl;
import com.buba.personnel.pojo.Departinfo;
import com.buba.personnel.service.DepartinfoService;

import java.util.List;
import java.util.Map;

public class DepartinfoServiceImpl implements DepartinfoService {

    DepartinfoDao departinfoDao = new DepartinfoDaoImpl();

    /**
     * 添加部门信息
     * @param param 查询条件
     */
    @Override
    public void addDepartinfo(Map<String, String> param) {
        departinfoDao.addDepartinfo(param);
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<Departinfo> selDp() {
        return departinfoDao.selDp();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public int upDp(String ids) {
        return departinfoDao.upDp(ids);
    }
}
