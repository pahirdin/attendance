package com.phd.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/27 11:36
 */
public class StaticUtils {

    public static Map<String,String> getRole() {
        HashMap<String, String> map = new HashMap<>();
        map.put("班主任权限","headmaster");
        map.put("辅导员权限","instructor");
        map.put("任课老师权限","teacherInClass");
        map.put("院级权限","collegeAdmin");
        map.put("校级权限","schoolAdmin");
        return map;
    }

    public static String getRoleNamesByRoleCodes(String roles) {
        HashMap<String, String> map = new HashMap<>();
        map.put("headmaster","班主任权限");
        map.put("instructor","辅导员权限");
        map.put("teacherInClass","任课老师权限");
        map.put("collegeAdmin","院级权限");
        map.put("schoolAdmin","校级权限");
        map.put("chushi","初始");
        StringBuffer rolesNames = new StringBuffer();
        String[] roleCode = roles.split(",");
        for(int i = 0;i < roleCode.length;i++ ){
            rolesNames.append(map.get(roleCode[i]));
            rolesNames.append(",");
        }
        rolesNames.deleteCharAt(rolesNames.length() - 1);
        return rolesNames.toString();
    }
}
