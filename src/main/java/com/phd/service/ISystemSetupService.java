package com.phd.service;

import com.github.pagehelper.PageInfo;
import com.phd.entity.AdminInfo;
import com.phd.entity.Classes;
import com.phd.entity.StudentInfo;

/**
 * @author pahaied
 * @date 2019/12/13 11:16
 */
public interface ISystemSetupService {
    PageInfo<Classes> findAllClasses(Integer page, Integer limit, Integer aid,Integer college,Integer major,String className);

    PageInfo<StudentInfo> findAllStudent(Integer page, Integer limit, Integer aid, String sno, Integer college, Integer major);

    PageInfo<AdminInfo> findAllAdminInfo(Integer page, Integer limit, Integer college, String role,String name, Integer aid);

    int deleteClassesInfo(Integer cid);
}
