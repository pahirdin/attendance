package com.phd.entity;

public class StudentInfo {
    private Integer sid;

    private String sno;

    private String sname;

    private String spwd;

    private Integer cid;

    private String stel;

    private String sdor;

    private String sptel;

    private Integer coid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd == null ? null : spwd.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getSdor() {
        return sdor;
    }

    public void setSdor(String sdor) {
        this.sdor = sdor == null ? null : sdor.trim();
    }

    public String getSptel() {
        return sptel;
    }

    public void setSptel(String sptel) {
        this.sptel = sptel == null ? null : sptel.trim();
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }
}