package com.java.boot.ant.service;

import com.java.boot.ant.entity.AntUser;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 19:16
 * @Description: No Description
 */
public interface ILoginService {
    AntUser selectByPrimaryKey(String antId,String password);
}
