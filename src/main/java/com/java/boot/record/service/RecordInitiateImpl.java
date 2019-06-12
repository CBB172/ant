package com.java.boot.record.service;

import com.java.boot.home.dao.AntUserMapper;
import com.java.boot.home.entity.AntUser;
import com.java.boot.record.dao.AntRecordMapper;
import com.java.boot.record.entity.AntRecordExample;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<AntRecordWithBLOBs> initiate(String uid, String password) {

        if(uid!=null&&!uid.equals("")&&!uid.equals("null")){
            AntUser user = antUserMapper.selectByPrimaryKey(uid);

            if(user.getAntPassword().equals(password)){
                //这是已登陆的用户[查看当前用户所有的日志简要信息]
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
        }
        AntRecordExample antRecordExample=new AntRecordExample();
        AntRecordExample.Criteria criteria = antRecordExample.createCriteria();
        criteria.andIsvalidEqualTo(true);//未被删除
        criteria.andAuthorEqualTo(0);//权限为公开
        criteria.andClassifyBetween(0,10000);//分类未被加密
        antRecordExample.setOrderByClause("publish_time DESC");//时间降序
        List<AntRecordWithBLOBs> records = antRecordMapper.selectByExampleWithBLOBs(antRecordExample);
        for(AntRecordWithBLOBs a:records){//清空Content
            a.setContentDetail("");
        }
        antRecordExample.clear();
        return records;
    }
}
