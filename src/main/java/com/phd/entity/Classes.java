package com.phd.entity;

import lombok.Data;

@Data
public class Classes {
    private Integer cid;
    private Integer masterid;
    private String masterName;
    private Integer insid;
    private String insName;

    private Integer mid;

    private String cname;

    //专业名称
    private String mname;
    //学院id
    private Integer coid;
    //学院名称
    private String coname;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

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
        this.coname = coname;
    }

    private College college;

//    private Major major;

    public Integer getCid() {
        return cid;
    }
    public Integer getMasterid() {
        return masterid;
    }
    public Integer getInsid() {
        return insid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }
    public void setInsid(Integer insid) {
        this.insid = insid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

}