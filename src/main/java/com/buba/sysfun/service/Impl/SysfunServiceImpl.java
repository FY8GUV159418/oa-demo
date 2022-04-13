package com.buba.sysfun.service.Impl;

import com.buba.sysfun.dao.Impl.SysfunDaoImpl;
import com.buba.sysfun.dao.SysfunDao;
import com.buba.sysfun.pojo.Sysfun;
import com.buba.sysfun.service.SysfunService;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 */
public class SysfunServiceImpl implements SysfunService {
    SysfunDao sysfunDao = new SysfunDaoImpl();
    @Override
    public List<Sysfun> selSysfun() {
        List<Sysfun> sysfuns = sysfunDao.selSysfun();
        List<Sysfun> list = new ArrayList<>();
        for (Sysfun sysfun : sysfuns){
            //如果该菜单的pid值0则说明该菜单是一个父级菜单
            if (sysfun.getParentNodeId() == 0){
                for (Sysfun m : sysfuns){
                    //判断子菜单的pid是否等于负菜单的id
                    if (m.getParentNodeId() == sysfun.getNodeId()){
                        //等于将子菜单添加到负菜单的list集合中
                        sysfun.add(m);
                    }
                }
                list.add(sysfun);
            }
        }
        return list;
    }
}
