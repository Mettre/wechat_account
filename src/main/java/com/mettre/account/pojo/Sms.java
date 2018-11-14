package com.mettre.account.pojo;

import java.util.Date;

public class Sms {
    private Long smsId;

    private String smsType;

    private String smsPhone;

    private String smsContent;

    private Date creationTime;

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType == null ? null : smsType.trim();
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone == null ? null : smsPhone.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}