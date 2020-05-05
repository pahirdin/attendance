package com.phd.entity;

import lombok.Data;

import java.util.Date;
@Data
public class SchoolAttendance {
    private Long said;

    private Integer cid;

    private Short sanum;

    private Short sainum;

    private Integer sarate;

    private Integer couid;

    private Short sacode;

    private Date satime;

    private String saaddress;

    private String couname;

    private String cname;

    private Integer leaveCont;
    private Integer attendaceCont;
}