package com.phd.entity;

import lombok.Data;

@Data
public class StudentInfo {
    private Integer sid;

    private String sno;

    private String sname;

    private String spwd;

    private Integer cid;
    private String cname;

    private String stel;

    private String sdor;

    private String sptel;

    private Integer coid;

    private Classes classes;

    private College college;

    private Integer leaveCont;

    private Integer attendaceCont;

}