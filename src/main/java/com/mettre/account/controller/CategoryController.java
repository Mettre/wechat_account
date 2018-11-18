package com.mettre.account.controller;

import com.mettre.account.base.Result;
import com.mettre.account.base.ResultUtil;
import com.mettre.account.pojoVM.CategoryVM;
import com.mettre.account.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "分类模块")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    @ApiOperation(value = "分类新增")
    public Result<Object> insert(@Valid @RequestBody CategoryVM categoryVM) {
        categoryService.insert(categoryVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/findCategoryList", method = RequestMethod.GET)
    @ApiOperation(value = "分类列表")
    public Result<Object> findCategoryList() {
        return new ResultUtil<>().setData(categoryService.getCategoryList());
    }


}
