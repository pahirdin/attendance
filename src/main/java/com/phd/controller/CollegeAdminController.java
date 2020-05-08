package com.phd.controller;

import com.phd.entity.AdminInfo;
import com.phd.entity.Course;
import com.phd.entity.Result;
import com.phd.entity.SchoolAttendance;
import com.phd.service.ITeacherControllerService;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-08
 */
@Controller
public class CollegeAdminController {
    @Autowired
    private ITeacherControllerService TeacherControllerServiceImpl;


    @RequestMapping("/openClassAttendanceCollegeAdmin")
    public String openClassAttendanceCollegeAdmin(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByStuCoid(admin.getCoid());
        model.addAttribute("course", course);
        return "collegeAdminInClass/classAttendanceCollegeAdmin.html";
    }

    @RequestMapping("/openStatisticsAttendanceCollegeAdmin")
    public String openStatisticsAttendanceCollegeAdmin(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByStuCoid(admin.getCoid());
        model.addAttribute("course", course);
        return "collegeAdminInClass/statisticsAttendanceCollegeAdmin.html";
    }

    @RequestMapping("/queryClassAttendanceCollegeAdmin")
    @ResponseBody
    public Result<SchoolAttendance> queryClassAttendanceCollegeAdmin(Integer page, Integer limit, Integer couid, Integer cid) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        if (couid == null || cid == null) {
            return new Result<>();
        }
        return new Result<>(this.TeacherControllerServiceImpl.queryClassAttendanceCollegeAdmin(page,limit,couid,cid,admin.getAid()));
    }

    @RequestMapping("/queryStatisticsAttendanceCollegeAdmin")
    @ResponseBody
    public Result<SchoolAttendance> queryStatisticsAttendanceCollegeAdmin(Integer page, Integer limit, Integer couid, Integer cid,String name) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();

        return new Result<>(this.TeacherControllerServiceImpl.queryStatisticsAttendanceCollegeAdmin(page,limit,couid,cid,name,admin));
    }


}
