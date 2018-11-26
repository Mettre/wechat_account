package com.mettre.account.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
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

    @RequestMapping(value = "/addFollow", method = RequestMethod.POST)
    @ApiOperation(value = "添加关注")
    public Result<Object> addFollow(@Valid @RequestBody FollowVM followVM) {

        followService.insert(followVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/cancelFollow", method = RequestMethod.POST)
    @ApiOperation(value = "取消关注")
    public Result<Object> cancelFollow(@Valid @RequestBody FollowVM followVM) {

        followService.cancelFollow(followVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/myFriendsList", method = RequestMethod.POST)
    @ApiOperation(value = "我的好友列表")
    public Result<Object> myFriendsPageVo(@RequestBody BasePage basePage, @RequestParam String userId) {
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFriendsPageVo(page, userId));
    }

    @RequestMapping(value = "/myFollowList", method = RequestMethod.POST)
    @ApiOperation(value = "我的关注列表识别互关")
    public Result<Object> myFollow2List(@RequestBody BasePage basePage, @RequestParam String userId) {
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFollowPageVo(page, userId));
    }

    @RequestMapping(value = "/myFansList", method = RequestMethod.POST)
    @ApiOperation(value = "我的粉丝列表识别互关")
    public Result<Object> myFans2List(@RequestBody BasePage basePage, @RequestParam String userId) {
        Page<Follow> page = new Page<>(basePage.getPage(), basePage.getSize());
        return new ResultUtil<>().setData(followService.myFansPageVo(page, userId));
    }

}
