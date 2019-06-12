package com.java.boot.record.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.boot.home.dao.AntUserMapper;
import com.java.boot.home.entity.AntUser;
import com.java.boot.home.service.ILoginService;
import com.java.boot.record.entity.AntRecord;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import com.java.boot.record.service.IRecordInitiate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping("initiate")//http://localhost:8080/record/initiate?uid=1723693876&password=1723693876
    @ResponseBody
    public PageInfo<AntRecordWithBLOBs> initiate(String uid, String password, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AntRecordWithBLOBs> initiate = iRecordInitiate.initiate(uid, password);
        return new PageInfo<>(initiate);
    }
}
