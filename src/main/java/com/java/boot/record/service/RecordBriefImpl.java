package com.java.boot.record.service;

import com.alibaba.fastjson.JSON;
import com.java.boot.record.dao.AntRecordMapper;
import com.java.boot.record.entity.AntRecord;
import com.java.boot.record.entity.AntRecordExample;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 15:58
 * @Description: No Description
 */
@Service
public class RecordBriefImpl implements IRecordBrief{

    @Resource
    private AntRecordMapper antRecordMapper;
    @Override
    public String getRecordBrief(String uid, String password,String uidHome, String pageNum, String pageSize) {
        AntRecordExample antRecordExample=new AntRecordExample();
        AntRecordExample.Criteria criteria = antRecordExample.createCriteria();
        if(uid!=null&&!uid.equals("")&&!uid.equals("null")&&uidHome!=null){
            if(uid.equals(uidHome)){
                //这是本人登陆的用户
                criteria.andIsvalidEqualTo(true);//设置有效为true
                criteria.andUserIdEqualTo(uid);//设置Uid为本人
            }else {
                //已登录的用户访问其他用户
                System.out.println(uid);
                System.out.println(uidHome);
                return null;
            }
        }else {
            //uid为空，游客访问
            criteria.andIsvalidEqualTo(true);//设置有效为true
            criteria.andUserIdEqualTo(uidHome);//Uid为访问的人
            criteria.andAuthorEqualTo(0);//公开才可访问
        }
        List<AntRecordWithBLOBs> antRecordWithBLOBs = antRecordMapper.selectByExampleWithBLOBs(antRecordExample);
        for (AntRecordWithBLOBs a:antRecordWithBLOBs){
        }
        return null;
    }
}
