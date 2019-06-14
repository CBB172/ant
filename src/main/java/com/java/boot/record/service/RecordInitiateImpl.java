package com.java.boot.record.service;

import com.alibaba.fastjson.JSON;
import com.java.boot.home.dao.AntUserMapper;
import com.java.boot.home.entity.AntUser;
import com.java.boot.record.dao.AntRecordClassifyMapper;
import com.java.boot.record.dao.AntRecordMapper;
import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordClassifyExample;
import com.java.boot.record.entity.AntRecordExample;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/11 20:01
 * @Description: No Description
 */
@Service
public class RecordInitiateImpl implements IRecordInitiate{
    @Resource
    private AntUserMapper antUserMapper;
    @Resource
    private AntRecordMapper antRecordMapper;
    @Resource
    private AntRecordClassifyMapper antRecordClassifyMapper;

    @Override
    public String isLogin(String uid, String password) {

        //判断登录正确是否
        if(uid!=null&&!uid.equals("")&&!uid.equals("null")){
            AntUser user = antUserMapper.selectByPrimaryKey(uid);
            if(user.getAntPassword().equals(password)){
                //正确登陆
                return user.getAntId();
            }else {
                //错误登录(uid 和 pwd 不匹配)
                return "-1";
            }
        }else {
            //游客登录
            return "0";
        }
    }

    @Override
    public List<AntRecordWithBLOBs> initiateVisitor() {

        //游客登录
        AntRecordExample antRecordExample=new AntRecordExample();
        AntRecordExample.Criteria criteria = antRecordExample.createCriteria();

        criteria.andAuthorEqualTo(0);//权限为公开
        criteria.andIsvalidEqualTo(true);//未被删除
        criteria.andClassifyBetween(0,10000);//分类未被加密
        antRecordExample.setOrderByClause("publish_time DESC");//时间降序

        List<AntRecordWithBLOBs> records = antRecordMapper.selectByExampleWithBLOBs(antRecordExample);
        for(AntRecordWithBLOBs a:records){//清空Content
            a.setContentDetail("");
        }
        antRecordExample.clear();
        return records;
    }

    @Override
    public List<AntRecordWithBLOBs> initiateUser(String uid, String password) {

        //已登陆的用户[查看当前用户所有的日志简要信息]
        AntRecordExample antRecordExample=new AntRecordExample();
        AntRecordExample.Criteria criteria = antRecordExample.createCriteria();

        criteria.andUserIdEqualTo(uid);//当前用户
        criteria.andIsvalidEqualTo(true);//未被删除
        antRecordExample.setOrderByClause("publish_time DESC");//时间降序

        List<AntRecordWithBLOBs> records = antRecordMapper.selectByExampleWithBLOBs(antRecordExample);
        for(AntRecordWithBLOBs a:records){//清空Content
            a.setContentDetail("");
        }
        antRecordExample.clear();
        return records;
    }

    @Override
    public Map<Integer,List<String[]>> getVisitorClassify() {
        AntRecordClassifyExample antRecordClassifyExample=new AntRecordClassifyExample();
        AntRecordClassifyExample.Criteria criteria = antRecordClassifyExample.createCriteria();
        criteria.andAuthorEqualTo(0);//权限为公开
        criteria.andIsvalidEqualTo(true);//可用为true
        List<AntRecordClassify> classifyList = antRecordClassifyMapper.selectByExample(antRecordClassifyExample);
        return serializeClassify(classifyList);
    }

    @Override
    public Map<Integer,List<String[]>> getUserClassify(String uid, String password) {
        AntRecordClassifyExample antRecordClassifyExample=new AntRecordClassifyExample();
        AntRecordClassifyExample.Criteria criteria = antRecordClassifyExample.createCriteria();
        criteria.andUserIdEqualTo(uid);//用户为uid
        criteria.andIsvalidEqualTo(true);//可用为true
        List<AntRecordClassify> classifyList = antRecordClassifyMapper.selectByExample(antRecordClassifyExample);
        return serializeClassify(classifyList);
    }

    private Map<Integer,List<String[]>> serializeClassify(List<AntRecordClassify> classifyList){
        Map<Integer,List<String[]>> map=new HashMap<>();
        for (AntRecordClassify arc:classifyList){
            Integer key=arc.getLevel();
            List<String[]>list=map.get(key);
            String[] strings={arc.getClassifyId().toString(),arc.getFid().toString(), JSON.toJSONString(arc)};
            if(list==null){
                list=new ArrayList<>();
                list.add(strings);
            }else {
                list.add(strings);
            }
            map.put(key,list);
        }
        return map;
    }
}
