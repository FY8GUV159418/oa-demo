package com.buba.login.service;

import com.buba.login.pojo.UserInfo;

import java.util.Map;

public interface LoginService {
    UserInfo login(Map<String, String> param);
}
