package com.phd.entity;

import lombok.Data;

import java.util.List;

@Data
public class AdminInfo {
    private String aid;

    private String aname;

    private String alevel;

    private String atel;

    private String ano;

    private String apwd;

    private Integer coid;

    private String coname;

    private String roles;

    private Integer awarnumm;
    private String aemail;

    private List<Role> roleList;
}