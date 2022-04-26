package com.buba.login.service.Impl;

import com.buba.login.dao.Impl.LoginDaoImpl;
import com.buba.login.dao.LoginDao;
import com.buba.login.pojo.UserInfo;
import com.buba.login.service.LoginService;

import java.util.Map;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public UserInfo login(Map<String, String> param) {
        return loginDao.login(param);
    }

    @Override
    public void addlogin(Map<String, String> paramMap) {
        loginDao.addlogin(paramMap);
    }
}
