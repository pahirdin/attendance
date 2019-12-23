package com.phd.entity;

public class LeavePicture {
    private Integer lpid;

    private Integer lid;

    private String lppath;

    public Integer getLpid() {
        return lpid;
    }

    public void setLpid(Integer lpid) {
        this.lpid = lpid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLppath() {
        return lppath;
    }

    public void setLppath(String lppath) {
        this.lppath = lppath == null ? null : lppath.trim();
    }
}