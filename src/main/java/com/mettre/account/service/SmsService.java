package com.mettre.account.service;

import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.pojo.Sms;
import com.mettre.account.pojoVM.SmsSearchVm;
import com.mettre.account.pojoVM.SmsVM;

public interface SmsService {

    int deleteByPrimaryKey(Long smsId);

    int insert(SmsVM smsVM) throws ClientException;

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(Long smsId);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);

    Page<Sms> findSmsListPageVo(Page<Sms> page, SmsSearchVm smsSearchVm);

    String sendMessage(SmsVM smsVM) throws ClientException;
}
