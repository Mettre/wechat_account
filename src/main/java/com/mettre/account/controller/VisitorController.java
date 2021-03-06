package com.mettre.account.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.jwt.SecurityContextStore;
import com.mettre.account.pojo.BasePage;
import com.mettre.account.pojo.Follow;
import com.mettre.account.pojo.Visitor;
import com.mettre.account.pojoVM.VisitorVM;
import com.mettre.account.service.VisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "空间访问")
public class VisitorController {

    @Autowired
    public VisitorService visitorService;

    @RequestMapping(value = "/loginEd/addVisitor", method = RequestMethod.POST)
    @ApiOperation(value = "访问别人的空间")
    public Result<Object> insert(@Valid @RequestBody VisitorVM visitorVM) {
        String userId = SecurityContextStore.getContext().getUserId();
        visitorService.insert(new Visitor(visitorVM, userId));
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/loginEd/myVisitorList", method = RequestMethod.POST)
    @ApiOperation(value = "我的空间访问记录")
    public Result<Object> myVisitorList(@RequestBody BasePage basePage) {
        String visitorsUser = SecurityContextStore.getContext().getUserId();
        Page<Visitor> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(visitorService.myVisitorPageVo(page, visitorsUser));
    }

    @RequestMapping(value = "/loginEd/deletePersonalVisitor", method = RequestMethod.POST)
    @ApiOperation(value = "主人删除空间访问某个人记录")
    public Result<Object> deletePersonalVisitor(@RequestParam(value = "visitorId", required = false) Long visitorId) {
        visitorService.deleteAllVisitorFromVisitorId(visitorId);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/deleteStripVisitor", method = RequestMethod.GET)
    @ApiOperation(value = "删除空间访问某单条记录")
    public Result<Object> deleteStripVisitor(@RequestParam Long visitorId) {
        visitorService.deleteByPrimaryKey(visitorId);
        return new ResultUtil<>().setSuccess();
    }

}
