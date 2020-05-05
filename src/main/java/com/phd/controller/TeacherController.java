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
 * @date 2020-05-05
 */
@Controller
public class TeacherController {
    @Autowired
    private ITeacherControllerService TeacherControllerServiceImpl;


    @RequestMapping("/openClassAttendanceTeacher")
    public String editInstructorInClass(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByAid(admin.getAid());
        model.addAttribute("course", course);
        return "teacherInClass/ClassAttendanceTeacher.html";
    }
    @RequestMapping("/getClassesByCouid")
    @ResponseBody
    public List<Classes> getClassesByCouid(Integer couid){
        return this.TeacherControllerServiceImpl.getClassesByCouid(couid);
    }
    @RequestMapping("/queryClassAttendanceTeacher")
    @ResponseBody
    public Result<SchoolAttendance> queryClassAttendanceTeacher(Integer page, Integer limit,Integer couid,Integer cid) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        if (couid == null || cid == null) {
            return new Result<>();
        }
        return new Result<>(this.TeacherControllerServiceImpl.queryClassAttendanceTeacher(page,limit,couid,cid,admin.getAid()));
    }
}
