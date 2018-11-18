package com.mettre.account.serviceimpl;

import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.mapper.CategoryMapper;
import com.mettre.account.pojo.Category;
import com.mettre.account.pojoVM.CategoryVM;
import com.mettre.account.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryImpl implements CategoryService {

    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Long categoryId) {
        return 0;
    }

    @Override
    public int insert(CategoryVM categoryVM) {
        if (categoryMapper.selectByCategoryName(categoryVM.getCategoryName())!=null) {
            throw new CustomerException(ResultEnum.CATEGORYCREATED);
        }
        Category category = new Category(categoryVM);
        return categoryMapper.insert(category);
    }

    @Override
    public int insertSelective(Category record) {
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Long categoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
