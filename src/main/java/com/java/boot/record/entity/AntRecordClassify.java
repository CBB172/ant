package com.java.boot.record.entity;

import java.util.Date;

public class AntRecordClassify {
    private Integer classifyId;

    private Integer fid;

    private String userId;

    private String classifyName;

    private String comment;

    private Integer author;

    private Integer level;

    private Date updateTime;

    private Boolean isvalid;

    public AntRecordClassify(Integer classifyId, Integer fid, String userId, String classifyName, String comment, Integer author, Integer level, Date updateTime, Boolean isvalid) {
        this.classifyId = classifyId;
        this.fid = fid;
        this.userId = userId;
        this.classifyName = classifyName;
        this.comment = comment;
        this.author = author;
        this.level = level;
        this.updateTime = updateTime;
        this.isvalid = isvalid;
    }

    public AntRecordClassify() {
        super();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
}