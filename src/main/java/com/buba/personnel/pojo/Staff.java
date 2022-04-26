package com.buba.personnel.pojo;

import lombok.Data;

@Data
public class Staff {
    private String UserId; //员工id
    private String UserName; //真实姓名
    private String Password; //密码
    private int DepartId; //所在部门
    private String DepartName; //所在部门
    private int Gender; //性别
    private int RoleId; //用户角色
    private String RoleName; //用户角色
    private int UserState; // 用户状态
}
