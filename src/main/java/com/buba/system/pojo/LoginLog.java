package com.buba.system.pojo;

import lombok.Data;

@Data
public class LoginLog {
    private int loginId; //登录日志id
    private String userId; //登录者
    private String loginTime; //登录时间
    private int IfSuccess; //登录是否成功
    private String loginUserIp; //登录用户ip
    private String LoginDesc; //登录备注
    private String userName;  //登录者名字
}
