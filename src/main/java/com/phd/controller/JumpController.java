package com.phd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * @author pahaied
 * @date 2019/12/13 10:44
 */
@Controller
public class JumpController {

    @RequestMapping("/login")
    public String login(){
        return "/login/login.html";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "/login/welcome.html";
    }

    /**
     * 导入结果弹窗处理
     * @param tol 总数
     * @param suc 成功总数
     * @param erro 失败总数
     * @param recordid 错误文件下载流水号
     * @param model model
     * @return 跳转到结果显示页面
     */
    @RequestMapping("/popupresults")
    public String popupresults(String tol,String suc,String erro,String recordid,Model model){
        if("0".equals(tol)) {
            //没有解析到文件
            model.addAttribute("type", "0");
        }else {
            //有成功的
            if("0".equals(erro)){
                //全部成功
                model.addAttribute("type", "1");
            }else {
                //有成功有失败
                model.addAttribute("type", "2");
            }
        }
        model.addAttribute("tol", tol);
        model.addAttribute("suc", suc);
        model.addAttribute("erro", erro);
        model.addAttribute("url", "/geterror?recordid="+recordid);
        return "/systemSetup/popupresults.html";
    }

    @RequestMapping("/collegeadminsetupclasses")
    public String collegeadminsetupclasses() {
        return "/systemSetup/collegeadminsetupclasses.html";
    }

}
