package com.phd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
