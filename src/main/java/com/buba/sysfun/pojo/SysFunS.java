package com.buba.sysfun.pojo;

import lombok.Data;

@Data
public class SysFunS {
    private int id;
    private String name;
    private int pId;
    private boolean checked;
    private boolean open = true;
}
