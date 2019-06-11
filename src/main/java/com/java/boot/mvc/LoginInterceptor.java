package com.java.boot.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 18:46
 * @Description: No Description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private LoginInterceptor(){}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("***前置拦截***");
        HttpSession session = request.getSession();
        return (session.getAttribute("loginAntUser")!=null);
    }
}
