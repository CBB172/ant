package com.java.boot.record.dao;

import com.java.boot.record.entity.AntRecord;
import com.java.boot.record.entity.AntRecordExample;
import com.java.boot.record.entity.AntRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntRecordMapper {
    long countByExample(AntRecordExample example);

    int deleteByExample(AntRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(AntRecordWithBLOBs record);

    int insertSelective(AntRecordWithBLOBs record);

    List<AntRecordWithBLOBs> selectByExampleWithBLOBs(AntRecordExample example);

    List<AntRecord> selectByExample(AntRecordExample example);

    AntRecordWithBLOBs selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") AntRecordWithBLOBs record, @Param("example") AntRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") AntRecordWithBLOBs record, @Param("example") AntRecordExample example);

    int updateByExample(@Param("record") AntRecord record, @Param("example") AntRecordExample example);

    int updateByPrimaryKeySelective(AntRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AntRecordWithBLOBs record);

    int updateByPrimaryKey(AntRecord record);
}