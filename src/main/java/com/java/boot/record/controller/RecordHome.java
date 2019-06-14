package com.java.boot.record.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.Map;

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
        if(uid==null){
            //游客登录
            Map<Integer, List<String[]>> classify = iRecordInitiate.getVisitorClassify();
            model.addAttribute("folder",classify);
            return "record/RecordHome";
        }else {
            String login = iRecordInitiate.isLogin(uid, password);
            if(!login.equals("0")&&!login.equals("-1")){
                //正常登录
                Map<Integer, List<String[]>> classify = iRecordInitiate.getUserClassify(uid, password);
                model.addAttribute("folder",classify);
            }else if(login.equals("-1")){
                //uid和密码不匹配
                session.removeAttribute("loginUser");
                model.addAttribute("tips","对不起，登录时效过期，请重新登录！");
            }
            return "record/RecordHome";
        }
    }

    @RequestMapping("initiate")//http://localhost:8080/record/initiate?uid=1723693876&password=1723693876
    @ResponseBody
    public PageInfo<AntRecordWithBLOBs> initiate(String uid, String password, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        //获取主要的最近日志简要
        PageHelper.startPage(pageNum,pageSize);
        List<AntRecordWithBLOBs> initiate;
        if(uid!=null){
            //正常登录
            initiate = iRecordInitiate.initiateUser(uid, password);
            return new PageInfo<>(initiate);
        }else {
            //游客登录
            initiate = iRecordInitiate.initiateVisitor();
            return new PageInfo<>(initiate);
        }
    }

}
