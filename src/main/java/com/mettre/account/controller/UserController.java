package com.mettre.account.controller;

import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.feign.TestClient;
import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.UserVM;
import com.mettre.account.service.UserService;
import com.mettre.account.util.BigDecimalUtils;
import groovy.transform.Field;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;

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

        String phone =userVM.getPhone();
        String password = userVM.getPassword();
        return new ResultUtil<>().setData(userService.selectByPhoneAndPassword(phone,password));

    }


    @GetMapping(value = "/user/hello")
    public String hello() {
        return testClient.consumer();
    }

}
