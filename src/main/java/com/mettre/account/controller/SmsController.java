package com.mettre.account.controller;

import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.pojo.BasePage;
import com.mettre.account.pojo.Sms;
import com.mettre.account.pojo.Visitor;
import com.mettre.account.pojoVM.FollowVM;
import com.mettre.account.pojoVM.SmsSearchVm;
import com.mettre.account.pojoVM.SmsVM;
import com.mettre.account.service.SmsService;
import com.mettre.account.serviceimpl.SmsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "短信模块")
public class SmsController {

    private static final Logger logger = LoggerFactory.getLogger(SmsController.class);


    @Autowired
    public SmsService smsService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信")
    public Result<Object> addFollow(@Valid @RequestBody SmsVM smsVM) throws ClientException {
        return new ResultUtil<>().setData(smsService.sendMessage(smsVM));
    }

    @RequestMapping(value = "/sendMessagePageVo", method = RequestMethod.POST)
    @ApiOperation(value = "查询发送短信记录")
    public Result<Object> myVisitorList(@Valid @RequestBody SmsSearchVm smsVM) {
        Page<Sms> page = new Page<>(smsVM.getPage(), smsVM.getSize());
        return new ResultUtil<>().setData(smsService.findSmsListPageVo(page, smsVM));
    }

    @RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
    @ApiOperation(value = "删除短信记录")
    public Result<Object> myVisitorList(@RequestParam Long smsId) {
        smsService.deleteByPrimaryKey(smsId);
        return new ResultUtil<>().setSuccess();
    }
}
