package com.java.boot.record.service;

import com.java.boot.record.entity.AntRecordWithBLOBs;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/11 20:01
 * @Description: No Description
 */
public interface IRecordInitiate {

    List<AntRecordWithBLOBs> initiate(String uid, String password);
}
