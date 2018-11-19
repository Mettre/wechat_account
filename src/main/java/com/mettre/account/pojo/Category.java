package com.mettre.account.pojo;

import com.mettre.account.pojoVM.CategoryVM;
import lombok.Data;

import java.util.Date;

@Data
public class Category {

    private Long categoryId;

    private String categoryName;

    private Date updateTime;

    private Date creationTime;

    private Boolean isShow;

    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.isShow = true;
        this.creationTime = new Date();
        this.updateTime = new Date();
    }

    //新增分类
    public Category(CategoryVM categoryVM) {
        this.categoryName = categoryVM.getCategoryName();
        this.creationTime = new Date();
        this.isShow = true;
        this.updateTime = new Date();
    }
}