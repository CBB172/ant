package com.java.boot.anttalk.handler;

import com.java.boot.anttalk.entity.AntTalk;
import com.java.boot.anttalk.service.talkImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/talk")
public class talkUser {
    @Autowired
    private talkImpl talk;
    @RequestMapping("userone")
    @ResponseBody
    public List<AntTalk> queryTalk(String userid){
        List<AntTalk> antTalks = talk.queryUserOne(userid);
        return antTalks;
    }

    @RequestMapping("/r{pageName}")
    public String gopage(@PathVariable("pageName")String pageName){
        return pageName;
    }
}
