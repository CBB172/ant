package com.java.boot.record.controller;

import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordSel;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import com.java.boot.record.service.IRecordInitiate;
import com.java.boot.record.service.IRecordSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/15 15:41
 * @Description: No Description
 */
@RequestMapping("/record")
@Controller
public class RecordSelect {

    @Autowired
    private IRecordSelect iRecordSelect;

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
        return "record/Record::mm1";
    }

}
