package com.java.boot.record.controller;

import com.java.boot.record.service.IRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 15:57
 * @Description: No Description
 */
@RequestMapping("/record")
@Controller
public class RecordBrief {
    @RequestMapping("recordbrief")
    public String recordBrief(HttpSession session,String uidHome){
        Object user = session.getAttribute("loginUser");

        return null;
    }
}
