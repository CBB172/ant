package com.java.boot.anttalk.service;

import com.java.boot.anttalk.dao.AntTalkMapper;
import com.java.boot.anttalk.dao.AntTalkPicMapper;
import com.java.boot.anttalk.entity.AntTalk;
import com.java.boot.anttalk.entity.AntTalkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class talkImpl {
    @Autowired
    private AntTalkMapper antTalkMapper;
    @Autowired
    private AntTalkPicMapper antTalkPicMapper;


    public List<AntTalk> queryUserOne(String userid){

        AntTalkExample antTalkExample=new AntTalkExample();
        AntTalkExample.Criteria criteria = antTalkExample.createCriteria();
        criteria.andUserIdEqualTo(userid);

        List<AntTalk> antTalks = antTalkMapper.selectByExampleWithBLOBs(antTalkExample);

        return antTalks;
    }
}
