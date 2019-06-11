package com.java.boot.home.entity;

import java.util.Date;

public class AntUser {
    private String antId;

    private String antPassword;

    private Date updatetime;

    private Long state;

    public AntUser(String antId, String antPassword, Date updatetime, Long state) {
        this.antId = antId;
        this.antPassword = antPassword;
        this.updatetime = updatetime;
        this.state = state;
    }

    public AntUser() {
        super();
    }

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId == null ? null : antId.trim();
    }

    public String getAntPassword() {
        return antPassword;
    }

    public void setAntPassword(String antPassword) {
        this.antPassword = antPassword == null ? null : antPassword.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}