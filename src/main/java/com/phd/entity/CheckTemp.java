package com.phd.entity;

import java.math.BigDecimal;

public class CheckTemp {
    private Integer tid;

    private Integer tno;

    private String tname;

    private String tpwd;

    private String ttel;

    private String coname;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    private String spare5;

    private String recordid;

    private Integer checcode;

    private String checkinfo;

    private BigDecimal tmpid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd == null ? null : tpwd.trim();
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel == null ? null : ttel.trim();
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname == null ? null : coname.trim();
    }

    public Integer getSpare1() {
        return spare1;
    }

    public void setSpare1(Integer spare1) {
        this.spare1 = spare1;
    }

    public Integer getSpare2() {
        return spare2;
    }

    public void setSpare2(Integer spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4 == null ? null : spare4.trim();
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5 == null ? null : spare5.trim();
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid == null ? null : recordid.trim();
    }

    public Integer getCheccode() {
        return checcode;
    }

    public void setCheccode(Integer checcode) {
        this.checcode = checcode;
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }

    public BigDecimal getTmpid() {
        return tmpid;
    }

    public void setTmpid(BigDecimal tmpid) {
        this.tmpid = tmpid;
    }
}