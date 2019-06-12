package com.java.boot.anttalk.dao;

import com.java.boot.anttalk.entity.AntTalk;
import com.java.boot.anttalk.entity.AntTalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntTalkMapper {
    long countByExample(AntTalkExample example);

    int deleteByExample(AntTalkExample example);

    int deleteByPrimaryKey(Integer talkId);

    int insert(AntTalk record);

    int insertSelective(AntTalk record);

    List<AntTalk> selectByExampleWithBLOBs(AntTalkExample example);

    List<AntTalk> selectByExample(AntTalkExample example);

    AntTalk selectByPrimaryKey(Integer talkId);

    int updateByExampleSelective(@Param("record") AntTalk record, @Param("example") AntTalkExample example);

    int updateByExampleWithBLOBs(@Param("record") AntTalk record, @Param("example") AntTalkExample example);

    int updateByExample(@Param("record") AntTalk record, @Param("example") AntTalkExample example);

    int updateByPrimaryKeySelective(AntTalk record);

    int updateByPrimaryKeyWithBLOBs(AntTalk record);

    int updateByPrimaryKey(AntTalk record);
}