package com.java.boot.record.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/18 18:00
 * @Description: No Description
 */
@Getter
@Setter
public class AntRecordSel {
    private String uid;
    private String password;
    private Integer classifyId=0;
    private Integer pageNum=0;
    private Integer pageSize=0;
    private String startTime;
    private String endTime;
    private String keywords;
    private String contentWords;
    private Integer author;
}
