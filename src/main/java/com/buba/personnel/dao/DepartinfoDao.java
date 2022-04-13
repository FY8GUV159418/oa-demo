package com.buba.personnel.dao;

import com.buba.personnel.pojo.Departinfo;

import java.util.List;
import java.util.Map;

public interface DepartinfoDao {

    /**
     * 添加
     * @param map
     */
    void addDepartinfo(Map<String, String> map);

    /**
     * 查询
     * @return
     */
    List<Departinfo> selDp();

    int upDp(String ids);
}
