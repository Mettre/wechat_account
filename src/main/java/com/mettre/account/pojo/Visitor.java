package com.mettre.account.pojo;

import com.mettre.account.pojoVM.VisitorVM;
import lombok.Data;

import java.util.Date;

@Data
public class Visitor {

    private Long visitorId;

    private Date creationTime;

    private String userId;

    private String visitorsUesr;

    private String userName;

    public Visitor() {
    }

    public Visitor(VisitorVM visitorVM,String userId) {
        this.creationTime = new Date();
        this.userId = userId;
        this.visitorsUesr = visitorVM.getVisitorsUesr();
    }
}