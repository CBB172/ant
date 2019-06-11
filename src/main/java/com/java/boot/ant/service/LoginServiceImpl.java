package com.java.boot.ant.service;

import com.java.boot.ant.dao.AntUserMapper;
import com.java.boot.ant.entity.AntUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 19:02
 * @Description: No Description
 */
@Service
public class LoginServiceImpl implements ILoginService{

    @Resource
    private AntUserMapper antUserMapper;
    @Override
    public AntUser selectByPrimaryKey(String antId,String password) {

        return antUserMapper.selectByPrimaryKey(antId);
    }
}
