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

    /**
     * 是否拥有该权限
     * @param ano 账号
     * @param rolename 权限名
     * @return true拥有  false没有
     */
    Boolean isGotRole(String ano, String rolename);

    /**
     * 删除管理员对应的权限
     * @param roleName 权限名
     * @param sno 管理员账号
     * @return 成功标识
     */
    void checkedDelRole(String roleName, String sno);

    /**
     * 新增管理员对应的权限
     * @param roleName 权限名
     * @param sno 管理员权限
     * @return 成功标识
     */
    void checkedAddRole(String roleName, String sno);
}
