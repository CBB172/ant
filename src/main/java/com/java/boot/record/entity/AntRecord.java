package com.java.boot.record.entity;

import java.util.Date;

public class AntRecord {
    private Integer recordId;

    private String userId;

    private String recordTitle;

    private Integer publishTime;

    private Integer author;

    private Integer classify;

    private Integer viewCount;

    private Integer approveCount;

    private Integer disapproveCount;

    private Date updateTime;

    private Boolean isvalid;

    private Boolean istop;

    public AntRecord(Integer recordId, String userId, String recordTitle, Integer publishTime, Integer author, Integer classify, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Boolean isvalid, Boolean istop) {
        this.recordId = recordId;
        this.userId = userId;
        this.recordTitle = recordTitle;
        this.publishTime = publishTime;
        this.author = author;
        this.classify = classify;
        this.viewCount = viewCount;
        this.approveCount = approveCount;
        this.disapproveCount = disapproveCount;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
        this.istop = istop;
    }

    public AntRecord() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle == null ? null : recordTitle.trim();
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getApproveCount() {
        return approveCount;
    }

    public void setApproveCount(Integer approveCount) {
        this.approveCount = approveCount;
    }

    public Integer getDisapproveCount() {
        return disapproveCount;
    }

    public void setDisapproveCount(Integer disapproveCount) {
        this.disapproveCount = disapproveCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    public Boolean getIstop() {
        return istop;
    }

    public void setIstop(Boolean istop) {
        this.istop = istop;
    }
}