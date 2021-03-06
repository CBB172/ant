package com.java.boot.record.service;

import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/11 20:01
 * @Description: No Description
 */
public interface IRecord {

    //判断是否登录或是否登录有误(uid 和 pwd不匹配)
    String isLogin(String uid, String password);

    //【游客】时间顺序获取日志简要
    List<AntRecordWithBLOBs> initiateVisitor(int pageNum, int pageSize);

    //【登录人】时间顺序获取日志简要
    List<AntRecordWithBLOBs> initiateUser(String uid, String password,int pageNum, int pageSize);

    //获取【游客】文件夹和子文件夹分类数量
    List<AntRecordClassify> getVisitorClassify();

    //获取【登录用户】的文件夹和子文件夹分类数量
    List<AntRecordClassify> getUserClassify(String uid, String password);
}
