package com.mettre.account.pojo;

import com.mettre.account.enum_.SmsTypeEnum;
import com.mettre.account.pojoVM.SmsVM;
import com.mettre.account.util.CreateVerifyCode;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Sms implements Serializable {

    private Long smsId;

    private SmsTypeEnum smsType;

    private String smsPhone;

    private String smsContent;

    private Date creationTime;

    private String userId;

    private String userName;

    public Sms() {
    }

//    新增短信
    public Sms(SmsVM smsVM,String code) {
        this.smsType = smsVM.getSmsType();
        this.smsPhone = smsVM.getSmsPhone();
        this.smsContent = code;
        this.creationTime = new Date();
    }
}