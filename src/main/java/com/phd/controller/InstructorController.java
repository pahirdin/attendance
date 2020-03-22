package com.phd.controller;

import com.phd.entity.AdminInfo;
import com.phd.entity.ClassCode;
import com.phd.service.IInstructorService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/getClassInstructorNonSelect")
    @ResponseBody
    public List<ClassCode> getClassInstructorNonSelect() {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return this.instructorServiceImpl.getClassInstructorNonSelect(admin);
    }

    @RequestMapping("/getClassInstructorSelect")
    @ResponseBody
    public List<ClassCode> getClassInstructorSelect() {
//        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
//        return this.instructorServiceImpl.getClassInstructorNonSelect(admin);
        return null;
    }
}
