package com.java.boot.record.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 15:57
 * @Description: No Description
 */
public interface IRecordBrief {
    String getRecordBrief(String uid,String password,String uidHome,String pageNum,String pageSize);
}
