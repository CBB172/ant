package com.java.boot.record.service;

import com.java.boot.record.entity.AntRecordWithBLOBs;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/15 15:29
 * @Description: No Description
 */
public interface IRecordSelect {
    //【游客】时间顺序获取日志选择性的简要(根据分类Id)
    List<AntRecordWithBLOBs> recordSelectVisitor(int pageNum, int pageSize);

    //【登录人】时间顺序获取日志简要(根据分类Id)
    List<AntRecordWithBLOBs> recordSelectUser(String uid, String password,String classifyId,int pageNum,int pageSize);
}
