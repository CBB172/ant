package com.java.boot.anttalk.entity;

public class AntTalkPic {
    private Integer pid;

    private Integer talkId;

    private String picUrl;

    public AntTalkPic(Integer pid, Integer talkId, String picUrl) {
        this.pid = pid;
        this.talkId = talkId;
        this.picUrl = picUrl;
    }

    public AntTalkPic() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}