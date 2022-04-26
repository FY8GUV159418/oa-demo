package com.buba.sysfun.service;

import com.buba.login.pojo.UserInfo;
import com.buba.sysfun.pojo.SysFun;
import com.buba.sysfun.pojo.SysFunS;

import java.util.List;
import java.util.Map;

public interface SysFunService {


    List<SysFun> selectRole(Map<String, String> param);

    List<SysFunS> selectAll();

    List<SysFun> selSysfun(UserInfo user);
}
