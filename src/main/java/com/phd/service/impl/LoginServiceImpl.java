package com.phd.service.impl;

import com.phd.entity.AdminInfo;
import com.phd.mapper.RoleMapper;
import com.phd.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author pahaied
 * @date 2019/12/10 14:26
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public String login(AdminInfo admin) {
        String adminName = admin.getAname().trim();
        String PWD = admin.getApwd().trim();

        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        // 2、判断当前用户是否登录
        if (currentUser.isAuthenticated() == false) {
            // 3、将用户名和密码封装到UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(adminName, PWD);
            // 4、认证
            try {
                currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
                Session session = currentUser.getSession();
                session.setAttribute("adminName", adminName);
                return "/index.html";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                System.out.println("登录失败");
                return "/demo/erro.html";
            }
        }else{
            System.out.println("登录失败11");
            return "/demo/erro.html";
        }
    }
}
