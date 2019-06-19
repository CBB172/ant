package com.java.boot.record.controller;

import com.github.pagehelper.PageInfo;
import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordSel;
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
    public String recordPage(AntRecordSel antRecordSel, Model model, HttpSession session){
        List<AntRecordClassify> classify=null;
        List<AntRecordWithBLOBs> contentBrief=null;
        if(antRecordSel.getUid()==null){
            //游客登录
            classify = iRecordInitiate.getVisitorClassify();
            contentBrief = iRecordInitiate.initiateVisitor(antRecordSel.getPageNum(), antRecordSel.getPageSize());
        }else {
            String login = iRecordInitiate.isLogin(antRecordSel.getUid(), antRecordSel.getPassword());
            if(!login.equals("0")&&!login.equals("-1")){
                //正常登录
                classify = iRecordInitiate.getUserClassify(antRecordSel.getUid(), antRecordSel.getPassword());
                contentBrief = iRecordInitiate.initiateUser(antRecordSel.getUid(), antRecordSel.getPassword(),antRecordSel.getPageNum(),antRecordSel.getPageSize());
            }else if(login.equals("-1")){
                //uid和密码不匹配
                session.removeAttribute("loginUser");
                classify = iRecordInitiate.getVisitorClassify();
                contentBrief = iRecordInitiate.initiateVisitor(antRecordSel.getPageNum(), antRecordSel.getPageSize());
                model.addAttribute("tips","对不起，登录时效过期，请重新登录！");
            }
        }
        model.addAttribute("classify",classify);
        model.addAttribute("contentBrief",contentBrief);
        return "record/Record";
    }

    @RequestMapping("initiateData")
    @ResponseBody
    public PageInfo<AntRecordWithBLOBs> initiate(String uid, String password){
        return null;
    }
}
