package com.phd.controller;

import com.phd.entity.*;
import com.phd.service.ITeacherControllerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String openClassAttendanceTeacher(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByAid(admin.getAid());
        model.addAttribute("course", course);
        return "teacherInClass/classAttendanceTeacher.html";
    }

    @RequestMapping("/openStuAttendanceTeacher")
    public String openStuAttendanceTeacher(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByAid(admin.getAid());
        model.addAttribute("course", course);
        return "teacherInClass/StuAttendanceTeacher.html";
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

    @RequestMapping("/queryStuAttendanceTeacher")
    @ResponseBody
    public Result<StudentInfo> queryStuAttendanceTeacher(Integer page, Integer limit,Integer couid,Integer cid,String start,String end,String name) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.TeacherControllerServiceImpl.queryStuAttendanceTeacher(page,limit,couid,cid,admin.getAid(),start,end,name));
    }


    @RequestMapping("/openkAttendanceStateBysaid")
    public String openkAttendanceStateBysaid(Long said, Integer state, Model model) {
        model.addAttribute("said", said);
        model.addAttribute("state", state);
        return "teacherInClass/checkStuAttendance.html";
    }

    @RequestMapping("/openCheckLeavDil")
    public String openCheckLeavDil(Integer sid, String start, String end, Model model) {
        model.addAttribute("sid", sid);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "teacherInClass/checkLeavDil.html";
    }


    @RequestMapping("/checkAttendanceStateBysaid")
    @ResponseBody
    public Result<StudentInfo> checkAttendanceStateBysaid(Long said, Integer state,Integer page, Integer limit) {
        if (said == null || state == null) {
            return new Result<>();
        }
        Result<StudentInfo> studentInfoResult = new Result<>(this.TeacherControllerServiceImpl.checkAttendanceStateBysaid(said, state, page, limit));
        return studentInfoResult;
    }

    @RequestMapping("/checkLeavDil")
    @ResponseBody
    public Result<SchoolAttendance> checkLeavDil(Integer sid, String start,String end,Integer page, Integer limit) {
        if (sid == null) {
            return new Result<>();
        }
        Result<SchoolAttendance> schoolAttendance = new Result<>(this.TeacherControllerServiceImpl.checkLeavDil(sid, start,end, page, limit));
        return schoolAttendance;
    }



    @RequestMapping("/deleteSchoolattendanceInfo")
    @ResponseBody
    public String deleteSchoolattendanceInfo(Long said) {
        if (said == null) {
            return "未收到删除主键！";
        }
        int cont = this.TeacherControllerServiceImpl.deleteSchoolattendanceInfo(said);
        if(cont > 0 ) {
            return "200";
        }
        return "数据库连接失败，请联系管理员....";
    }
}
