package com.buba.sysfun.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Sysfun {
    private int nodeId;
    private String displayName;
    private String nodeURL;
    private int displayOrder;
    private int parentNodeId;

    private List<Sysfun>sublist = new ArrayList<>();

    public void add(Sysfun m) {
        sublist.add(m);
    }
}

