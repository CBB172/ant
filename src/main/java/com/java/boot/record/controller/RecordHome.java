package com.java.boot.record.controller;

import com.github.pagehelper.PageInfo;
import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import com.java.boot.record.service.IRecordInitiate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/11 19:54
 * @Description: No Description
 */
@RequestMapping("record")
@Controller
public class RecordHome {

    @Autowired
    private IRecordInitiate iRecordInitiate;

    @RequestMapping("record")
    public String recordPage(String uid, String password, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10")int pageSize, Model model, HttpSession session){
        List<AntRecordClassify> classify=null;
        List<AntRecordWithBLOBs> contentBrief=null;
        if(uid==null){
            //游客登录
            classify = iRecordInitiate.getVisitorClassify();
            contentBrief = iRecordInitiate.initiateVisitor(pageNum, pageSize);
        }else {
            String login = iRecordInitiate.isLogin(uid, password);
            if(!login.equals("0")&&!login.equals("-1")){
                //正常登录
                classify = iRecordInitiate.getUserClassify(uid, password);
                contentBrief = iRecordInitiate.initiateUser(uid, password,pageNum,pageSize);
            }else if(login.equals("-1")){
                //uid和密码不匹配
                session.removeAttribute("loginUser");
                classify = iRecordInitiate.getVisitorClassify();
                contentBrief = iRecordInitiate.initiateVisitor(pageNum, pageSize);
                model.addAttribute("tips","对不起，登录时效过期，请重新登录！");
            }
        }
        model.addAttribute("classify",classify);
        model.addAttribute("contentBrief",contentBrief);
        return "record/RecordHome";
    }

    @RequestMapping("initiateData")
    @ResponseBody
    public PageInfo<AntRecordWithBLOBs> initiate(String uid, String password){
        return null;
    }
}
