package com.phd.entity;

import java.util.Date;

public class SchoolAttendanceDetails {
    private Integer sadid;

    private Integer said;

    private Integer couid;

    private Integer sid;

    private String sadstatus;

    private Date sadtime;

    private String sadaddress;

    public Integer getSadid() {
        return sadid;
    }

    public void setSadid(Integer sadid) {
        this.sadid = sadid;
    }

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSadstatus() {
        return sadstatus;
    }

    public void setSadstatus(String sadstatus) {
        this.sadstatus = sadstatus == null ? null : sadstatus.trim();
    }

    public Date getSadtime() {
        return sadtime;
    }

    public void setSadtime(Date sadtime) {
        this.sadtime = sadtime;
    }

    public String getSadaddress() {
        return sadaddress;
    }

    public void setSadaddress(String sadaddress) {
        this.sadaddress = sadaddress == null ? null : sadaddress.trim();
    }
}