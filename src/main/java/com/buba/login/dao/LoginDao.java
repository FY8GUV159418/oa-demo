package com.buba.login.dao;

import com.buba.login.pojo.UserInfo;

import java.util.Map;

public interface LoginDao {
    UserInfo login(Map<String, String> param);

    void addlogin(Map<String, String> paramMap);
}
