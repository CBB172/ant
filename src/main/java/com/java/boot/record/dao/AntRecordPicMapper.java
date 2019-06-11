package com.java.boot.record.dao;

import com.java.boot.record.entity.AntRecordPic;
import com.java.boot.record.entity.AntRecordPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AntRecordPicMapper {
    long countByExample(AntRecordPicExample example);

    int deleteByExample(AntRecordPicExample example);

    int insert(AntRecordPic record);

    int insertSelective(AntRecordPic record);

    List<AntRecordPic> selectByExample(AntRecordPicExample example);

    int updateByExampleSelective(@Param("record") AntRecordPic record, @Param("example") AntRecordPicExample example);

    int updateByExample(@Param("record") AntRecordPic record, @Param("example") AntRecordPicExample example);
}