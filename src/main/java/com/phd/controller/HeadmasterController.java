package com.phd.controller;

import com.phd.entity.AdminInfo;
import com.phd.entity.Course;
import com.phd.service.ITeacherControllerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
