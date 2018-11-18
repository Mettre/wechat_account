package com.mettre.account.mapper;

import com.mettre.account.pojo.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {

    int deleteByPrimaryKey(Long categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long categoryId);

    Category selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getCategoryList();
}