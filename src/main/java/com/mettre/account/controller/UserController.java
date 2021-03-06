package com.mettre.account.controller;

import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.feign.TestClient;
import com.mettre.account.jwt.SecurityContextStore;
import com.mettre.account.pojoVM.ForgetPasswordVM;
import com.mettre.account.pojoVM.ModifyPasswordVM;
import com.mettre.account.pojoVM.UserRegisterVM;
import com.mettre.account.pojoVM.UserVM;
import com.mettre.account.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "用户模块")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public TestClient testClient;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public Result<Object> insert(@Valid @RequestBody UserRegisterVM userVM) {
        userService.insert(userVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public Result<Object> login(@RequestParam String phone, @RequestParam String password) {
        return new ResultUtil<>().setData(userService.selectByPhoneAndPassword(phone, password));
    }

    @RequestMapping(value = "/loginEd/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取个人信息")
    public Result<Object> findUserInfo() {
        String userId = SecurityContextStore.getContext().getUserId();
        return new ResultUtil<>().setData(userService.selectByPrimaryKey(userId));
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "根据userId查询个人信息")
    public Result<Object> findUserInfoWithUserId(@RequestParam String userId) {
        return new ResultUtil<>().setData(userService.selectByPrimaryKey(userId));
    }

    @RequestMapping(value = "/loginEd/modifyUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "修改个人信息")
    public Result<Object> modifyUserInfo(@RequestBody UserVM userVM) {
        String userId = SecurityContextStore.getContext().getUserId();
        userService.updateByPrimaryKeySelective(userVM, userId);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    @ApiOperation(value = "忘记密码")
    public Result<Object> forgetPassword(@Valid @RequestBody ForgetPasswordVM userVM) {
        userService.forgetPassword(userVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/loginEd/modifyPassword", method = RequestMethod.POST)
    @ApiOperation(value = "修改密码")
    public Result<Object> modifyPassword(@Valid @RequestBody ModifyPasswordVM userVM) {
        userService.modifyPassword(userVM);
        return new ResultUtil<>().setSuccess();
    }

    @GetMapping(value = "/user/hello")
    public String hello() {
        return testClient.consumer();
    }

}
