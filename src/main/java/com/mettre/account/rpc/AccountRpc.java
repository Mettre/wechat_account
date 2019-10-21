package com.mettre.account.rpc;

import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.pojo.Visitor;
import com.mettre.account.pojoVM.VisitorRpcVM;
import com.mettre.account.service.VisitorService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rpc")
@Slf4j
public class AccountRpc {

    @Autowired
    public VisitorService visitorService;

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    @ApiOperation(value = "访问别人的空间")
    public Result<Object> insert(@Valid @RequestBody VisitorRpcVM visitorVM) {
        visitorService.insert(new Visitor(visitorVM.getVisitorsUser(), visitorVM.getUserId()));
        return new ResultUtil<>().setSuccess();
    }


}
