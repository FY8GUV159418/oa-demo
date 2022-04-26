package com.buba.system.service.Impl;

import com.buba.system.dao.Impl.LoginLogDaoImpl;
import com.buba.system.dao.LoginLogDao;
import com.buba.system.pojo.LoginLog;
import com.buba.system.service.LoginLogService;

import java.util.List;
import java.util.Map;

public class LoginLogServiceImpl implements LoginLogService {

    LoginLogDao loginLogDao = new LoginLogDaoImpl();

    /**
     * 查询登录日志
     * @param param
     * @return
     */
    @Override
    public List<LoginLog> selLog(Map<String, String> param) {
        return loginLogDao.selLog(param);
    }
}
