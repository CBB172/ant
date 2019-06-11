package com.java.boot.record.entity;

public class AntRecordPic {
    private Integer pid;

    private Integer recordId;

    private String picUrl;

    public AntRecordPic(Integer pid, Integer recordId, String picUrl) {
        this.pid = pid;
        this.recordId = recordId;
        this.picUrl = picUrl;
    }

    public AntRecordPic() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}