package com.mettre.account.controller;

import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.feign.TestClient;
import com.mettre.account.pojo.User;
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
    public Result<Object> insert(@Valid @RequestBody UserVM userVM) {
        userService.insert(userVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public Result<Object> login(@Valid @RequestBody UserVM userVM) {

        String phone = userVM.getPhone();
        String password = userVM.getPassword();
        return new ResultUtil<>().setData(userService.selectByPhoneAndPassword(phone, password));
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取个人信息")
    public Result<Object> findUserInfo(@Valid @PathVariable String userId) {
        User user = userService.selectByPrimaryKey(userId);
        if (user == null) {
            throw new CustomerException(ResultEnum.USERIDNOT);
        }
        return new ResultUtil<>().setData(user);
    }


    @GetMapping(value = "/user/hello")
    public String hello() {
        return testClient.consumer();
    }

}
