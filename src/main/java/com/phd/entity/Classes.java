package com.phd.entity;

import lombok.Data;

@Data
public class Classes {
    private Integer cid;
    private String masterid;
    private String masterName;
    private String insid;
    private String insName;

    private Integer mid;

    private String cname;

    //专业名称
    private String mname;
    //学院id
    private Integer coid;
    //学院名称
    private String coname;
}