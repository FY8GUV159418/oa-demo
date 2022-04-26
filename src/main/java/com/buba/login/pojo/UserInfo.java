package com.buba.login.pojo;

import lombok.Data;

@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String passWord;
    private int departId;
    private int gender;
    private int roleId;
    private int userState;
    private String roleName;
    private String departName;
}

