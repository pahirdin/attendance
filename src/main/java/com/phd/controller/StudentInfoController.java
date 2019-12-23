package com.phd.controller;

import com.phd.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author pahaied
 * @date 2019/12/5 14:38
 */
@Controller
public class StudentInfoController {
    @Autowired
    private IStudentInfoService studentInfoServiceImpl;

//    @RequestMapping("/getStudent")
//    public String getListStudent(Model model) {
//        List<StudentInfo> list =  this.studentInfoServiceImpl.getStudentList();
//        model.addAttribute("studentList",list);
//        return "studentlist";
//    }
//
//    @RequestMapping("/login")
//    public String getLogin() {
//        return "/login/login.html";
//    }
//    @RequestMapping("/index")
//    public String getIndex() {
//        return "demo/index.html";
//    }
//
//    //用于spring mvc 跳转访问Thyemaleaf模板
//    @RequestMapping("/tiao")
//    public String page(@PathVariable String page) {
//        return "/demo/"+page;
//    }
}
