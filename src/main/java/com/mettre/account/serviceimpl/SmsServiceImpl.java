package com.mettre.account.serviceimpl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.ReturnType;
import com.mettre.account.config.LogHttpServletRequestWrapper;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.enum_.SmsTypeEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.mapper.SmsMapper;
import com.mettre.account.pojo.Sms;
import com.mettre.account.pojoVM.SmsSearchVm;
import com.mettre.account.pojoVM.SmsVM;
import com.mettre.account.service.SmsService;
import com.mettre.account.util.SmsDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SmsServiceImpl implements SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Autowired
    public SmsMapper smsMapper;

    @Override
    public int deleteByPrimaryKey(Long smsId) {
        int type = smsMapper.deleteByPrimaryKey(smsId);
        return ReturnType.ReturnType(type, ResultEnum.SMSDELETEERROR);
    }

    @Override
    public int insert(SmsVM smsVM) throws ClientException {

        if (null == smsVM.getSmsType()) {
            throw new CustomerException("短信类型不能为空");
        }
        int type = smsMapper.insert(new Sms(smsVM));
        if (type > 0) {
            SendSmsResponse response = SmsDemo.sendSms(smsVM.getSmsType(), smsVM);
            if ("OK".equals(response.getCode()) && "OK".equals(response.getMessage())) {
                return ReturnType.ReturnType(type, ResultEnum.SMS_SEND_ERROR);
            } else {
                return ReturnType.ReturnType(0, ResultEnum.SMS_SEND_ERROR);
            }
        } else {
            return ReturnType.ReturnType(0, ResultEnum.SMS_SEND_ERROR);
        }
    }

    @Override
    public int insertSelective(Sms record) {
        return 0;
    }

    @Override
    public Sms selectByPrimaryKey(Long smsId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Sms record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Sms record) {
        return 0;
    }

    @Override
    public Page<Sms> findSmsListPageVo(Page<Sms> page, SmsSearchVm smsSearchVm) {
        if (null != smsSearchVm.getSmsType() && !SmsTypeEnum.contains(smsSearchVm.getSmsType().name())) {
            throw new CustomerException("短信类型错误");
        }
        List<Sms> visitorList = (List<Sms>) smsMapper.findSmsListPageVo(page, smsSearchVm);
        page = page.setRecords(visitorList);
        return page;
    }
}
