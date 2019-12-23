package com.phd.controller;

import com.phd.entity.AdminInfo;
import com.phd.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author pahaied
 * @date 2019/12/10 14:29
 */
@Controller
public class AdminLoginController {
    @Autowired
    private ILoginService loginServiceImpl;

    @PostMapping(value = "/logon")
    public String logon(@Validated AdminInfo admin) {
        String adminName = admin.getAno().trim();
        String PWD = admin.getApwd().trim();

        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(adminName, PWD);
        // 4、认证
        try {
            currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
            Session session = currentUser.getSession();
            session.setAttribute("adminName", adminName);
            return "/login/index.html";
        } catch (AuthenticationException e) {
//                e.printStackTrace();
            System.out.println("登录失败");
            return "/login/error.html";
        }
    }
}
