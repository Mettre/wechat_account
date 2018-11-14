package com.mettre.account.mapper;

import com.mettre.account.pojo.Sms;

public interface SmsMapper {
    int deleteByPrimaryKey(Long smsId);

    int insert(Sms record);

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(Long smsId);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);
}