package com.java.boot.home.controller;

import com.java.boot.home.entity.AntUser;
import com.java.boot.home.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 18:44
 * @Description: No Description
 */
@Controller
@RequestMapping("/ant")
public class Login {

    @Autowired
    private ILoginService iLoginService;

    @RequestMapping("login")
    @ResponseBody
    public String login(String userId, String password, Model model, HttpServletRequest request){
        AntUser user=iLoginService.selectByPrimaryKey(userId,password);

        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("loginUser",user);
            return "200";
        }
        return "400";
    }
    @RequestMapping("Home")
    public String toHome(){
        return "home/Home";
    }
}
