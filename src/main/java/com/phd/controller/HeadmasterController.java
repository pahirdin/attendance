package com.phd.controller;

import com.phd.entity.*;
import com.phd.service.ITeacherControllerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-07
 */
@Controller
public class HeadmasterController {

    @Autowired
    private ITeacherControllerService TeacherControllerServiceImpl;

    @RequestMapping("/openClassAttendanceHeadmaster")
    public String openClassAttendanceHeadmaster(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        Integer cid = this.TeacherControllerServiceImpl.getCidByHeadmasterId(admin.getAid());
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByCid(cid);
        model.addAttribute("course", course);
        model.addAttribute("cid", cid);
        return "headmasterInClass/classAttendanceHeadmaster.html";
    }

    @RequestMapping("/openStuAttendanceHeadmaster")
    public String openStuAttendanceHeadmaster(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        Integer cid = this.TeacherControllerServiceImpl.getCidByHeadmasterId(admin.getAid());
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByCid(cid);
        model.addAttribute("course", course);
        model.addAttribute("cid", cid);
        return "headmasterInClass/StuAttendanceHeadmaster.html";
    }

    @RequestMapping("/openStuLeavesHeadmaster")
    public String openStuLeavesHeadmaster(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        Integer cid = this.TeacherControllerServiceImpl.getCidByHeadmasterId(admin.getAid());
        model.addAttribute("cid", cid);
        return "headmasterInClass/stuLeavesHeadmaster.html";
    }

    @RequestMapping("/queryStuLeaves")
    @ResponseBody
    public Result<Leave> queryStuLeaves(Integer page, Integer limit,  Integer cid, Integer lstatus,String name) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.TeacherControllerServiceImpl.queryStuLeaves(page,limit,admin.getAid(),lstatus,cid,name));
    }

    @RequestMapping("/updateLeave")
    @ResponseBody
    public String updateLeave(Integer lid,Integer lstatus){
        this.TeacherControllerServiceImpl.updateLeave(lid,lstatus);
        return "200";
    }

    @RequestMapping("/openSetInformation")
    private String openSetInformation(Model model) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("awarnumm",admin.getAwarnumm());
        model.addAttribute("aemail",admin.getAemail());
        return "headmasterInClass/setInformation.html";
    }
    @RequestMapping("/setInformation")
    @ResponseBody
    public String setInformation(Integer awarnumm,String aemail){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        this.TeacherControllerServiceImpl.setInformation(awarnumm,aemail,admin.getAid());
        return "200";
    }
}
