package com.phd.controller;

import com.phd.entity.*;
import com.phd.service.ICommomService;
import com.phd.service.IInstructorService;
import com.phd.service.ITeacherControllerService;
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
    @Autowired
    private ITeacherControllerService TeacherControllerServiceImpl;

    @RequestMapping("/openClassAttendanceInstructor")
    public String openClassAttendanceInstructor(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByInsAid(admin.getAid());
        model.addAttribute("course", course);
        return "instructorInClass/classAttendanceInstructor.html";
    }

    @RequestMapping("/openStuAttendanceInstructor")
    public String openStuAttendanceInstructor(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Course> course = this.TeacherControllerServiceImpl.queryCourseByInsAid(admin.getAid());
        model.addAttribute("course", course);
        return "instructorInClass/StuAttendanceInstructor.html";
    }

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


    @RequestMapping("/openStuLeavesInstructor")
    public String openStuLeavesHeadmaster(Model model){
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        List<Classes> classes = this.TeacherControllerServiceImpl.queryClassesByInsAid(admin.getAid());
        model.addAttribute("classes", classes);
        return "instructorInClass/stuLeavesInstructor.html";
    }

    @RequestMapping("/queryStuLeavesIns")
    @ResponseBody
    public Result<Leave> queryStuLeavesIns(Integer page, Integer limit, Integer cid, Integer lstatus, String name) {
        AdminInfo admin = (AdminInfo) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(this.TeacherControllerServiceImpl.queryStuLeavesIns(page,limit,admin.getAid(),lstatus,cid,name));
    }
}
