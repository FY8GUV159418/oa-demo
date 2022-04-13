package com.buba.personnel.pojo;

//角色类
import lombok.Data;

import java.math.BigInteger;

@Data
public class Departinfo {
    private int DepartId; //部门id
    private String DepartName; //部门名称
    private String PrincipalUser; //部门负责人
    private Long ConnectTeNo; //联系电话
    private Long ConnectMobileTelNo; //移动电话
    private Long Faxes; //传真
}
