package com.phd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.time.LocalDateTime;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime satime;

    private String saaddress;

    private String couname;

    private String cname;

    private Integer leaveCont;
    private Integer attendaceCont;
}