package com.buba.sysfun.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SysFun {
    private int nodeId;
    private String displayName;
    private String nodeURL;
    private int displayOrder;
    private int parentNodeId;
    private int roleId;

    private List<SysFun> sysfunList = new ArrayList<>();

    public void add(SysFun sysfun) {
        sysfunList.add(sysfun);
    }
}

