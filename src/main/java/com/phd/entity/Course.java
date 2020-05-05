package com.phd.entity;

public class Course {
    private Integer couid;

    private String couname;

    private String aid;

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname == null ? null : couname.trim();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }
}