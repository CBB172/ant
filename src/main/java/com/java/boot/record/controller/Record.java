package com.java.boot.record.controller;

import com.java.boot.home.entity.AntUser;
import com.java.boot.home.service.ILoginService;
import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordSel;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import com.java.boot.record.service.IRecord;
import com.java.boot.record.service.IRecordSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/11 19:54
 * @Description: No Description
 */
@RequestMapping("/record")
@Controller
public class Record {

    @Autowired
    private ILoginService iLoginService;
    //总的Record转发处理器
    @RequestMapping("{s}/{w}")
    public String transController(@PathVariable String s, @PathVariable String w, HttpSession session, Model model, HttpServletResponse response){
        try {
            //从Redis/(数据库)取值判断session用户
            AntUser sessionUser=(AntUser)session.getAttribute("loginUser");
            if(sessionUser!=null&&sessionUser.getAntId()!=null&&sessionUser.getAntPassword()!=null&&s!=null){
                AntUser user = iLoginService.selectByPrimaryKey(sessionUser.getAntId(), sessionUser.getAntPassword());
                if(user!=null){
                    //正常人登录
                    if(user.getAntId()!=null){
                        if(user.getAntId().equals(s)){
                            //本人登录并查看自己空间
                            response.sendRedirect("/record/"+w);
                            return "record/Record";
                        }else {
                            //访问好友日志空间
                            response.sendRedirect("/record/"+w);
                        }
                    }
                }else {
                    //session里用户名/密码错误，密码在别处被修改！
                    model.addAttribute("tips","对不起，您的密码被修改！当前session已被清除，请重新登陆！");
                    session.removeAttribute("loginUser");
                    response.sendRedirect("/record"+w);
                    //[游客访问]
                }
            }else if(s!=null){
                //[游客访问]
            }else {
                //访问为空，session为空，砸场子的这是
                model.addAttribute("tips","这位游客，请问你想要访问谁的空间？");
                return null;
            }
        }catch (Exception e){
            //用户对象转换异常，session异常，也是砸场子的
            model.addAttribute("tips","session转换异常，砸场子的？");
            return null;
        }
        return null;
    }




    @Autowired
    private IRecord iRecordInitiate;
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
        return "Record";
    }

    @Autowired
    private IRecordSelectService iRecordSelect;

    @RequestMapping("recordselect")
    public String recordClassify(AntRecordSel antRecordSel, Model model, HttpSession session){
        List<AntRecordWithBLOBs> contentBrief=null;
        if(antRecordSel.getUid()==null){
            //游客登录
            contentBrief = iRecordSelect.recordSelectVisitor(antRecordSel.getClassifyId(),antRecordSel.getPageNum(),antRecordSel.getPageSize());
        }else {
            //正常登录
            contentBrief = iRecordSelect.recordSelectUser(antRecordSel.getUid(), antRecordSel.getPassword(),antRecordSel.getClassifyId(),antRecordSel.getPageNum(),antRecordSel.getPageSize());
        }
        model.addAttribute("contentBrief",contentBrief);
        return "Record::mm1";
    }
}
