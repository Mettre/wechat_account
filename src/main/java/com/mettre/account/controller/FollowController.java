package com.mettre.account.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.jwt.SecurityContextStore;
import com.mettre.account.pojo.BasePage;
import com.mettre.account.pojo.Follow;
import com.mettre.account.pojoVM.FollowVM;
import com.mettre.account.service.FollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "关注")
public class FollowController {

    @Autowired
    public FollowService followService;

    @RequestMapping(value = "/loginEd/addFollow", method = RequestMethod.POST)
    @ApiOperation(value = "添加关注")
    public Result<Object> addFollow(@Valid @RequestBody FollowVM followVM) {
        followService.insert(followVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/loginEd/cancelFollow", method = RequestMethod.POST)
    @ApiOperation(value = "取消关注")
    public Result<Object> cancelFollow(@Valid @RequestBody FollowVM followVM) {
        followService.cancelFollow(followVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/loginEd/myFriendsPo", method = RequestMethod.POST)
    @ApiOperation(value = "我的好友列表分页")
    public Result<Object> myFriendsPageVo(@RequestBody BasePage basePage) {
        String userId = SecurityContextStore.getContext().getUserId();
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFriendsPageVo(page, userId));
    }

    @RequestMapping(value = "/loginEd/myFriendsList", method = RequestMethod.GET)
    @ApiOperation(value = "我的好友列表")
    public Result<Object> myFriendsList() {
        String userId = SecurityContextStore.getContext().getUserId();
        return new ResultUtil<>().setData(followService.myFriendsList(userId));
    }

    @RequestMapping(value = "/loginEd/myFollowList", method = RequestMethod.POST)
    @ApiOperation(value = "我的关注列表识别互关")
    public Result<Object> myFollowList(@RequestBody BasePage basePage) {
        String userId = SecurityContextStore.getContext().getUserId();
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFollowPageVo(page, userId));
    }

    @RequestMapping(value = "/loginEd/myFansList", method = RequestMethod.POST)
    @ApiOperation(value = "我的粉丝列表识别互关")
    public Result<Object> myFansList(@RequestBody BasePage basePage) {
        String userId = SecurityContextStore.getContext().getUserId();
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFansPageVo(page, userId));
    }

}
