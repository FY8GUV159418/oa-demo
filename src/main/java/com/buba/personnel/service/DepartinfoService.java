package com.buba.personnel.service;

import com.buba.personnel.pojo.Departinfo;

import java.util.List;
import java.util.Map;

public interface DepartinfoService {

    /**
     * 添加
     * @param param
     */
    void addDepartinfo(Map<String, String> param);

    /**
     * 查询
     * @return
     */
    List<Departinfo> selDp();

    /**
     * 删除
     * @param ids
     * @return
     */
    int upDp(String ids);


}
