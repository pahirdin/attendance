package com.phd.entity;

public class Major {
    private Integer id;

    private Integer mid;

    private String mname;

    private Integer coid;

    public Major() {}

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public void setId(Integer id) {this.id = id;};

    public Integer getId() {return id;}
}