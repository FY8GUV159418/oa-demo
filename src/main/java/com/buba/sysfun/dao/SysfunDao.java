package com.buba.sysfun.dao;

import com.buba.sysfun.pojo.Sysfun;

import java.util.List;

/**
 * 菜单持久层接口
 */
public interface SysfunDao {
    /**
     * 查询菜单
     * @return
     */
    List<Sysfun> selSysfun();
}
