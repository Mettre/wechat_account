package com.mettre.account.service;

import com.mettre.account.pojo.Category;
import com.mettre.account.pojoVM.CategoryVM;

import java.util.List;

public interface CategoryService {

    int deleteByPrimaryKey(Long categoryId);

    int insert(CategoryVM categoryVM);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getCategoryList();

}
