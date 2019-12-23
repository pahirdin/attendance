package com.phd.controller;

import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.service.ICommomService;
import com.phd.service.ISystemSetupService;
import com.phd.utils.MyPageInfo;
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
    Result classInfoImport(Integer college,Integer major,String className,Integer page, Integer limit){
        //从shiro 获取当前登录用户信息
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        PageInfo<Classes> info = systemSetupServiceImpl.findAllClasses(page,limit,admin.getAid());
        MyPageInfo<Classes> classesMyPageInfo = new MyPageInfo<>(info);
        Result result = new Result(systemSetupServiceImpl.findAllClasses(page,limit,admin.getAid()));
        return result;
    }

    @RequestMapping("/getMajorByCoid")
    public @ResponseBody List<Major> getMajor(Integer coid) {
        List<Major> majorByCoid = this.commomServiceImpl.getMajorByCoid(coid);
        return majorByCoid;
    }

    @RequestMapping("/classTest")
    public String test(Integer college,Integer major,String className){

        return "systemSetup/classInfoImport.html";
    }
}
