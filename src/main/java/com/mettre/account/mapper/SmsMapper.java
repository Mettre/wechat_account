package com.mettre.account.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.pojo.Sms;
import com.mettre.account.pojoVM.SmsSearchVm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SmsMapper {
    int deleteByPrimaryKey(Long smsId);

    int insert(Sms record);

    int insertSelective(Sms record);

    Sms selectByPrimaryKey(Long smsId);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);

    List<Sms> findSmsListPageVo(Page<Sms> page, @Param(value = "smsSearchVm") SmsSearchVm smsSearchVm);

}