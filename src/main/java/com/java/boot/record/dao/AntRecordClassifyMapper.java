package com.java.boot.record.dao;

import com.java.boot.record.entity.AntRecordClassify;
import com.java.boot.record.entity.AntRecordClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntRecordClassifyMapper {
    long countByExample(AntRecordClassifyExample example);

    int deleteByExample(AntRecordClassifyExample example);

    int deleteByPrimaryKey(Integer classifyId);

    int insert(AntRecordClassify record);

    int insertSelective(AntRecordClassify record);

    List<AntRecordClassify> selectByExample(AntRecordClassifyExample example);

    AntRecordClassify selectByPrimaryKey(Integer classifyId);

    int updateByExampleSelective(@Param("record") AntRecordClassify record, @Param("example") AntRecordClassifyExample example);

    int updateByExample(@Param("record") AntRecordClassify record, @Param("example") AntRecordClassifyExample example);

    int updateByPrimaryKeySelective(AntRecordClassify record);

    int updateByPrimaryKey(AntRecordClassify record);
}