package com.mettre.account.feign;

import com.mettre.account.base.Result;
import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.VisitorVM;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@FeignClient("comment")
@RestController
public interface TestClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String consumer();

    @RequestMapping(value = "/rpc/getUserInfo", method = RequestMethod.GET)
    User selectByPrimaryKey(String userId);


}