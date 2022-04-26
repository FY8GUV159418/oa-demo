package com.buba.personnel.service.Impl;

import com.buba.personnel.dao.Impl.StaffDaoImpl;
import com.buba.personnel.dao.StaffDao;
import com.buba.personnel.pojo.Pagination;
import com.buba.personnel.pojo.Staff;
import com.buba.personnel.service.StaffService;

import java.util.List;
import java.util.Map;

public class StaffServiceImpl implements StaffService {
    StaffDao staffDao = new StaffDaoImpl();

    /**
     * 添加
     * @param param
     */
    @Override
    public void addStaff(Map<String, String> param) {
        staffDao.addStaff(param);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public int delStaff(String ids) {
        return staffDao.delStaff(ids);
    }

    /**
     * 修改
     * @param param
     * @return
     */
    @Override
    public int upStaff(Map<String, String> param) {
        return staffDao.upStaff(param);
    }

    /**
     * 查询员工
     * @param  pagination 工具类中携带了查询条件和分页数据
     * @return
     */
    @Override
    public long selCount(Pagination<Staff> pagination) {
        return staffDao.selCount(pagination);
    }

    /**
     * 查询员工
     * @param pagination 工具类中携带了查询条件和分页数据
     * @return
     */
    @Override
    public List<Staff> selStaff(Pagination<Staff> pagination) {
        return staffDao.selStaff(pagination);
    }

}
