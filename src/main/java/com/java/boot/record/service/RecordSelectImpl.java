package com.java.boot.record.service;

import com.java.boot.record.entity.AntRecordWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/15 15:29
 * @Description: No Description
 */
@Service
public class RecordSelectImpl implements IRecordSelect{
    @Override
    public List<AntRecordWithBLOBs> recordSelectVisitor(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<AntRecordWithBLOBs> recordSelectUser(String uid, String password, String classifyId, int pageNum, int pageSize) {
        return null;
    }
}
