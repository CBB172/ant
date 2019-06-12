package com.java.boot.anttalk.entity;

import java.util.Date;

public class AntTalk {
    private Integer talkId;

    private String userId;

    private Integer publishTime;

    private Short author;

    private Integer viewCount;

    private Integer approveCount;

    private Integer disapproveCount;

    private Date updateTime;

    private Byte isvalid;

    private String content;

    public AntTalk(Integer talkId, String userId, Integer publishTime, Short author, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Byte isvalid) {
        this.talkId = talkId;
        this.userId = userId;
        this.publishTime = publishTime;
        this.author = author;
        this.viewCount = viewCount;
        this.approveCount = approveCount;
        this.disapproveCount = disapproveCount;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
    }

    public AntTalk(Integer talkId, String userId, Integer publishTime, Short author, Integer viewCount, Integer approveCount, Integer disapproveCount, Date updateTime, Byte isvalid, String content) {
        this.talkId = talkId;
        this.userId = userId;
        this.publishTime = publishTime;
        this.author = author;
        this.viewCount = viewCount;
        this.approveCount = approveCount;
        this.disapproveCount = disapproveCount;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
        this.content = content;
    }

    public AntTalk() {
        super();
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
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