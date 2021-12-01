package com.yangzhou.intelligent.model;

import java.util.Date;

public class  YDVerifyCode {
    private Integer id;

    private String emailNumber;

    private String verifyCodeNumber;

    private Date date;

    private Integer ifverify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailNumber() {
        return emailNumber;
    }

    public void setEmailNumber(String emailNumber) {
        this.emailNumber = emailNumber == null ? null : emailNumber.trim();
    }

    public String getVerifyCodeNumber() {
        return verifyCodeNumber;
    }

    public void setVerifyCodeNumber(String verifyCodeNumber) {
        this.verifyCodeNumber = verifyCodeNumber == null ? null : verifyCodeNumber.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIfverify() {
        return ifverify;
    }

    public void setIfverify(Integer ifverify) {
        this.ifverify = ifverify;
    }
}