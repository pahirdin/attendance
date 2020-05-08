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
 * @date 2020-05-08
 */
@Controller
public class SchoolAdminController {
    @Autowired
    private ITeacherControllerService TeacherControllerServiceImpl;

    @RequestMapping("/openStatisticsAttendanceSchoolAdmin")
    public String openStatisticsAttendanceCollegeAdmin(Model model){
        return "schoolAdmin/statisticsAttendanceSchoolAdmin.html";
    }

    @RequestMapping("/queryStatisticsAttendanceSchoolAdmin")
    @ResponseBody
    public Result<SchoolAttendance> queryStatisticsAttendanceSchoolAdmin(Integer page, Integer limit, String start, String end) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.TeacherControllerServiceImpl.queryStatisticsAttendanceSchoolAdmin(page,limit,admin.getAid(),start,end));
    }
}
