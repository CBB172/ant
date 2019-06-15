package com.java.boot.record.entity;

import java.util.Date;

public class AntRecordWithBLOBs extends AntRecord {
    private String contentDetail;

    private String contentBrief;

    public AntRecordWithBLOBs(Integer recordId, String userId, String recordTitle, Integer publishTime, Integer author, Integer classify, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Boolean isvalid, Boolean istop, String contentDetail, String contentBrief) {
        super(recordId, userId, recordTitle, publishTime, author, classify, viewCount, approveCount, disapproveCount, updateTime, isvalid, istop);
        this.contentDetail = contentDetail;
        this.contentBrief = contentBrief;
    }

    public AntRecordWithBLOBs() {
        super();
    }

    public String getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(String contentDetail) {
        this.contentDetail = contentDetail == null ? null : contentDetail.trim();
    }

    public String getContentBrief() {
        return contentBrief;
    }

    public void setContentBrief(String contentBrief) {
        this.contentBrief = contentBrief == null ? null : contentBrief.trim();
    }
}