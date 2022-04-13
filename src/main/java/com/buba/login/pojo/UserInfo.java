package com.buba.login.pojo;

import lombok.Data;

@Data
public class UserInfo {
    private String UserId;
    private String UserName;
    private String PassWord;
    private int DepartId;
    private int Gender;
    private int RoleId;
    private int UserState;
}

