package com.java.boot.record.dao;

import com.java.boot.record.entity.AntRecord;
import com.java.boot.record.entity.AntRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntRecordMapper {
    long countByExample(AntRecordExample example);

    int deleteByExample(AntRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(AntRecord record);

    int insertSelective(AntRecord record);

    List<AntRecord> selectByExampleWithBLOBs(AntRecordExample example);

    List<AntRecord> selectByExample(AntRecordExample example);

    AntRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") AntRecord record, @Param("example") AntRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") AntRecord record, @Param("example") AntRecordExample example);

    int updateByExample(@Param("record") AntRecord record, @Param("example") AntRecordExample example);

    int updateByPrimaryKeySelective(AntRecord record);

    int updateByPrimaryKeyWithBLOBs(AntRecord record);

    int updateByPrimaryKey(AntRecord record);
}