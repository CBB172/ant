package com.java.boot.record.entity;

import java.util.Date;

public class AntRecord {
    private Integer recordId;

    private String userId;

    private Integer publishTime;

    private Short author;

    private Integer classify;

    private Integer viewCount;

    private Integer approveCount;

    private Integer disapproveCount;

    private Date updateTime;

    private Byte isvalid;

    private String content;

    public AntRecord(Integer recordId, String userId, Integer publishTime, Short author, Integer classify, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Byte isvalid) {
        this.recordId = recordId;
        this.userId = userId;
        this.publishTime = publishTime;
        this.author = author;
        this.classify = classify;
        this.viewCount = viewCount;
        this.approveCount = approveCount;
        this.disapproveCount = disapproveCount;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
    }

    public AntRecord(Integer recordId, String userId, Integer publishTime, Short author, Integer classify, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Byte isvalid, String content) {
        this.recordId = recordId;
        this.userId = userId;
        this.publishTime = publishTime;
        this.author = author;
        this.classify = classify;
        this.viewCount = viewCount;
        this.approveCount = approveCount;
        this.disapproveCount = disapproveCount;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
        this.content = content;
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

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Short getAuthor() {
        return author;
    }

    public void setAuthor(Short author) {
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

    public Byte getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Byte isvalid) {
        this.isvalid = isvalid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}