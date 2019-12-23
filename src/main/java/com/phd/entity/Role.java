package com.phd.entity;


import lombok.Data;


import java.io.Serializable;
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer role_id;//角色序号

    private String role_name;//角色名称

    private String role_description;//角色描述

}