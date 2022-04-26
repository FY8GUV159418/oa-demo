package com.buba.sysfun.dao;

import com.buba.login.pojo.UserInfo;
import com.buba.sysfun.pojo.SysFun;
import com.buba.sysfun.pojo.SysFunS;

import java.util.List;
import java.util.Map;

/**
 * 菜单持久层接口
 */
public interface SysFunDao {
    /**
     * 查询菜单
     * @return
     */

    List<SysFun> selectRole(Map<String, String> param);

    List<SysFunS> SysfunAll();

    List<SysFun> selSysfun(UserInfo user);
}
