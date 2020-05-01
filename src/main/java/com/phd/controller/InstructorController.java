package com.phd.controller;

import com.phd.entity.AdminInfo;
import com.phd.entity.ClassCode;
import com.phd.entity.Classes;
import com.phd.service.ICommomService;
import com.phd.service.IInstructorService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 辅导员权限的控制器
 * @author pahaied@asiainfo.com
 * @date 2020-03-22
 */
@Controller
public class InstructorController {

    @Autowired
    private IInstructorService instructorServiceImpl;
    @Autowired
    private ICommomService commomServiceImpl;

    @RequestMapping("/getClassInstructorNonSelect")
    @ResponseBody
    public List<ClassCode> getClassInstructorNonSelect() {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return this.instructorServiceImpl.getClassInstructorNonSelect(admin);
    }

    @RequestMapping("/getClassInstructorSelect")
    @ResponseBody
    public List<ClassCode> getClassInstructorSelect() {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<ClassCode> classInstructorNonSelect = this.instructorServiceImpl.getClassInstructorNonSelect(admin);
        return classInstructorNonSelect;
    }

    /**
     * 班级辅导员设置 初始化弹窗
     * @param cid 班级ID
     * @param model Model
     * @return 弹窗地址HTML
     */
    @RequestMapping("/editInstructorInClass")
    public String editInstructorInClass(String cid, Model model){
//        Classes classes = this.commomServiceImpl.queryClassesById(cid);
//        model.addAttribute("classes", classes);
        return "systemSetup/editInstructorInClass.html";
    }
}
