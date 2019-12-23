package com.phd.entity;

import java.util.Date;

public class SchoolAttendance {
    private Integer said;

    private Integer cid;

    private Short sanum;

    private Short sainum;

    private Float sarate;

    private Integer couid;

    private Short sacode;

    private Date satime;

    private String saaddress;

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Short getSanum() {
        return sanum;
    }

    public void setSanum(Short sanum) {
        this.sanum = sanum;
    }

    public Short getSainum() {
        return sainum;
    }

    public void setSainum(Short sainum) {
        this.sainum = sainum;
    }

    public Float getSarate() {
        return sarate;
    }

    public void setSarate(Float sarate) {
        this.sarate = sarate;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Short getSacode() {
        return sacode;
    }

    public void setSacode(Short sacode) {
        this.sacode = sacode;
    }

    public Date getSatime() {
        return satime;
    }

    public void setSatime(Date satime) {
        this.satime = satime;
    }

    public String getSaaddress() {
        return saaddress;
    }

    public void setSaaddress(String saaddress) {
        this.saaddress = saaddress == null ? null : saaddress.trim();
    }
}