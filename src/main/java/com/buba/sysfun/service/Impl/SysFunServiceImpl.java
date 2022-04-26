package com.buba.sysfun.service.Impl;

import com.buba.login.pojo.UserInfo;
import com.buba.sysfun.dao.Impl.SysFunDaoImpl;
import com.buba.sysfun.dao.SysFunDao;
import com.buba.sysfun.pojo.SysFun;
import com.buba.sysfun.pojo.SysFunS;
import com.buba.sysfun.service.SysFunService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 业务层
 */
public class SysFunServiceImpl implements SysFunService {
    SysFunDao sysfunDao = new SysFunDaoImpl();

    @Override
    public List<SysFun> selSysfun(UserInfo user) {
        List<SysFun> sysfuns = sysfunDao.selSysfun(user);
        System.out.println(sysfuns);
        List<SysFun> list = new ArrayList<>();
        for (SysFun sysfun : sysfuns){
            if (sysfun.getParentNodeId() == 0){
                for (SysFun m: sysfuns){
                    if (m.getParentNodeId() == sysfun.getNodeId()){
                        sysfun.add(m);
                    }
                }
                list.add(sysfun);
            }
        }
        return list;
    }

    @Override
    public List<SysFunS> selectAll() {
        return sysfunDao.SysfunAll();
    }

    @Override
    public List<SysFun> selectRole(Map<String, String> param) {
        return sysfunDao.selectRole(param);
    }
}
