package com.buba.system.dao;

import com.buba.system.pojo.LoginLog;

import java.util.List;
import java.util.Map;

public interface LoginLogDao {
    /**
     * 查询登录日志
     * @param param
     * @return
     */
    List<LoginLog> selLog(Map<String, String> param);
}
