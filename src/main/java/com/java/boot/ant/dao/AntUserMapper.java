package com.java.boot.ant.dao;

import com.java.boot.ant.entity.AntUser;
import com.java.boot.ant.entity.AntUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AntUserMapper {
    long countByExample(AntUserExample example);

    int deleteByExample(AntUserExample example);

    int deleteByPrimaryKey(String antId);

    int insert(AntUser record);

    int insertSelective(AntUser record);

    List<AntUser> selectByExample(AntUserExample example);

    AntUser selectByPrimaryKey(String antId);

    int updateByExampleSelective(@Param("record") AntUser record, @Param("example") AntUserExample example);

    int updateByExample(@Param("record") AntUser record, @Param("example") AntUserExample example);

    int updateByPrimaryKeySelective(AntUser record);

    int updateByPrimaryKey(AntUser record);
}