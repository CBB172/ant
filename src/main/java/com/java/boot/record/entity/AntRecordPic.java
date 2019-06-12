package com.java.boot.record.entity;

public class AntRecordPic {
    private Integer picId;

    private Integer recordId;

    private String picUrl;

    public AntRecordPic(Integer picId, Integer recordId, String picUrl) {
        this.picId = picId;
        this.recordId = recordId;
        this.picUrl = picUrl;
    }

    public AntRecordPic() {
        super();
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
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