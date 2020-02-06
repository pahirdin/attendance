package com.phd.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 * @author pahaied
 * @date 2020/2/6 15:23
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图跳转
        if(ex instanceof ArithmeticException){
            //这里有问题  跳不到指定页面
            mv.setViewName("error1.html");
        }
        if(ex instanceof NullPointerException){
            //这里有问题  跳不到指定页面
            mv.setViewName("error2.html");
        }
        mv.addObject("error", ex.toString());

        return mv;
    }
}

