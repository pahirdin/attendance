package com.phd.entity;

import java.util.Date;

public class Leave {
    private Integer lid;

    private Integer sid;

    private Date lstime;

    private Date letime;

    private String ltype;

    private String lcontent;

    private String aid;

    private String lstatus;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getLstime() {
        return lstime;
    }

    public void setLstime(Date lstime) {
        this.lstime = lstime;
    }

    public Date getLetime() {
        return letime;
    }

    public void setLetime(Date letime) {
        this.letime = letime;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype == null ? null : ltype.trim();
    }

    public String getLcontent() {
        return lcontent;
    }

    public void setLcontent(String lcontent) {
        this.lcontent = lcontent == null ? null : lcontent.trim();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getLstatus() {
        return lstatus;
    }

    public void setLstatus(String lstatus) {
        this.lstatus = lstatus == null ? null : lstatus.trim();
    }
}