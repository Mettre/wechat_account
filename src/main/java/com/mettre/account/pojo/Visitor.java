package com.mettre.account.pojo;

import java.util.Date;

public class Visitor {
    private String visitorId;

    private Date creationTime;

    private String userId;

    private String visitorsUesr;

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId == null ? null : visitorId.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getVisitorsUesr() {
        return visitorsUesr;
    }

    public void setVisitorsUesr(String visitorsUesr) {
        this.visitorsUesr = visitorsUesr == null ? null : visitorsUesr.trim();
    }
}