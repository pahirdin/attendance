package com.phd.transaction;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pahaied
 * @date 2019/12/4 17:50
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("loginuser");
        if(loginuser==null){
            request.setAttribute("msg","请先登录再访问");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }
}
