package com.phd.entity;

public class College {
    private Integer coid;

    private String coname;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname == null ? null : coname.trim();
    }
}