package com.buba.personnel.service;

import com.buba.personnel.pojo.Pagination;
import com.buba.personnel.pojo.Staff;

import java.util.List;
import java.util.Map;

public interface StaffService {


    /**
     * 添加
     * @param param
     */
    void addStaff(Map<String, String> param);

    /**
     * 删除
     * @param ids
     * @return
     */
    int delStaff(String ids);

    /**
     * 修改
     * @param param
     * @return
     */
    int upStaff(Map<String, String> param);

    /**
     *查询员工
     * @param  pagination 工具类中携带了查询条件和分页数据
     * @return 员工总条数
     */
    long selCount(Pagination<Staff> pagination);

    /**
     * 查询当前页的员工信息
     * @param pagination 工具类中携带了查询条件和分页数据
     * @return 当前页员工信息
     */
    List<Staff> selStaff(Pagination<Staff> pagination);
}
