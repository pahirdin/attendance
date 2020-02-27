package com.phd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.mapper.AdminInfoMapper;
import com.phd.mapper.ClassesMapper;
import com.phd.mapper.RoleMapper;
import com.phd.mapper.StudentInfoMapper;
import com.phd.service.ISystemSetupService;
import com.phd.utils.StaticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/13 11:16
 */
@Service
public class SystemSetupServiceImpl implements ISystemSetupService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private AdminInfoMapper adminInfoMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageInfo<Classes> findAllClasses(Integer page, Integer limit, Integer aid,Integer college,Integer major,String className) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        className = className == null ? null : "%"+className.trim()+"%";
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<Classes> list = classesMapper.selectAllClasses(college,major,className);
        PageInfo<Classes> pagelist = new PageInfo<Classes>(list);
        return pagelist;
    }

    @Override
    public PageInfo findAllStudent(Integer page, Integer limit, Integer aid, String sno, Integer college, Integer major) {
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        sno = sno == null ? null : "%"+sno.trim()+"%";
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<StudentInfo> list = studentInfoMapper.queryStudenInfoByParam(sno,college,major);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<AdminInfo> findAllAdminInfo(Integer page, Integer limit, Integer college, String role,String name, Integer aid) {
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        name = name == null ? null : "%"+name.trim()+"%";
        PageHelper.startPage(page, limit);
        List<AdminInfo> list = this.adminInfoMapper.queryAdminInfoByParam(college,role,name);
        for (AdminInfo admin : list) {
          admin.setRoles(StaticUtils.getRoleNamesByRoleCodes(admin.getRoles()));
        }
        return new PageInfo<>(list);
    }

    @Override
    public int deleteClassesInfo(Integer cid) {
        ClassesExample classesExample = new ClassesExample();
        ClassesExample.Criteria criteria = classesExample.createCriteria();
        criteria.andCidEqualTo(cid);
        return this.classesMapper.deleteByExample(classesExample);
    }

    @Override
    public Boolean isGotRole(String ano, String rolename) {
        return this.roleMapper.isGotRole(ano,rolename);
    }

    @Override
    public void checkedDelRole(String roleName, String sno) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleDescriptionEqualTo(roleName);
        criteria.andRoleNameEqualTo(sno);
        this.roleMapper.deleteByExample(roleExample);

        List<Role> roleList = this.roleMapper.selectAllByRolname(sno);
        //如果没有一个权限则赋初始权
        if(roleList.size() == 0) {
            this.roleMapper.insert(new Role(sno,"chushi"));
        }
    }

    @Override
    public void checkedAddRole(String roleName, String sno) {
        this.roleMapper.insert(new Role(sno,roleName));
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleDescriptionEqualTo("chushi");
        criteria.andRoleNameEqualTo(sno);
        this.roleMapper.deleteByExample(roleExample);
    }
}
