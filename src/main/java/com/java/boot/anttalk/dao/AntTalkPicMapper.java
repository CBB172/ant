package com.java.boot.anttalk.dao;

import com.java.boot.anttalk.entity.AntTalkPic;
import com.java.boot.anttalk.entity.AntTalkPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntTalkPicMapper {
    long countByExample(AntTalkPicExample example);

    int deleteByExample(AntTalkPicExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(AntTalkPic record);

    int insertSelective(AntTalkPic record);

    List<AntTalkPic> selectByExample(AntTalkPicExample example);

    AntTalkPic selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") AntTalkPic record, @Param("example") AntTalkPicExample example);

    int updateByExample(@Param("record") AntTalkPic record, @Param("example") AntTalkPicExample example);

    int updateByPrimaryKeySelective(AntTalkPic record);

    int updateByPrimaryKey(AntTalkPic record);
}