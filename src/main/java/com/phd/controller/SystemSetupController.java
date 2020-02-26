package com.phd.controller;

import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.service.ICommomService;
import com.phd.service.ISystemSetupService;
import com.phd.utils.StaticUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统设置
 * @author pahaied
 * @date 2019/12/13 11:05
 */
@Controller
public class SystemSetupController {

    @Autowired
    private ISystemSetupService systemSetupServiceImpl;
    @Autowired
    private ICommomService commomServiceImpl;

    /**
     * 班级导入init
     * @return
     */
    @RequestMapping("/classInfoImport")
    public String classInfoImport(Model model){
        List<College> collegelist = this.commomServiceImpl.findAllCollege();
        model.addAttribute("college", collegelist);
        return "systemSetup/classInfoImport.html";
    }

    /**
     * 班级导入
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getClassInfo")
    public  @ResponseBody
    Result<Classes> classInfoImport(Integer college,Integer major,String className,Integer page, Integer limit){
        //从shiro 获取当前登录用户信息
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.systemSetupServiceImpl.findAllClasses(page,limit,admin.getAid(),college,major,className));
    }

    @RequestMapping("/getMajorByCoid")
    public @ResponseBody List<Major> getMajor(Integer coid) {
        if(coid == null) {
            return null;
        }
        return this.commomServiceImpl.getMajorByCoid(coid);
    }

    @RequestMapping("/studentInfoImport")
    public String studentInfoImport(Model model){
        List<College> changelist = this.commomServiceImpl.findAllCollege();
        model.addAttribute("college", changelist);
        return "systemSetup/studentInfoImport.html";
    }
    @RequestMapping("/getStudentInfo")
    public @ResponseBody
    Result<StudentInfo> studentInfoImport(Integer page, Integer limit, String sno, Integer college, Integer major ){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.systemSetupServiceImpl.findAllStudent(page, limit, admin.getAid(),sno,college,major));
    }

    /**
     * 管理员管理页面初始化
     */
    @RequestMapping("/adminInfoImport")
    public String adminInfoImport(Model model) {
        List<College> changelist = this.commomServiceImpl.findAllCollege();
        model.addAttribute("college", changelist);
        model.addAttribute("roleMap",StaticUtils.getRole());
        return "systemSetup/adminInfoImport.html";
    }

    /**
     * 管理员管理页面 数据表格
     */
    @RequestMapping("/getAdminInfo")
    public @ResponseBody
    Result<AdminInfo> getAdminInfo(Integer page,Integer limit,Integer college,String role,String name) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        PageInfo<AdminInfo> pageInfo =  this.systemSetupServiceImpl.findAllAdminInfo(page,limit,college,role,name,admin.getAid());
        return new Result<>(pageInfo);
    }

    /**
     * 班级信息管理页面-删除班级
     * @param cid 班级ID
     * @return 返回错误或成功信息（200）
     */
    @RequestMapping("/deleteClassesInfo")
    @ResponseBody
    public String deleteClassesInfo(Integer cid) {
        int cont = this.systemSetupServiceImpl.deleteClassesInfo(cid);
        if(cont > 0 ) {
            return "200";
        }
        return "数据库连接失败，请联系管理员....";
    }
}
