package com.phd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Leave {
    private Integer lid;

    private Integer sid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lstime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date letime;

    private String ltype;

    private String lcontent;

    private String aid;

    private String lstatus;

    private String sname;
    private String ltypeName;
    private String lstatusName;
    private String aname;
}