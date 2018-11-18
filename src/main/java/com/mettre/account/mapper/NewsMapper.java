package com.mettre.account.mapper;

import com.mettre.account.pojo.News;

public interface NewsMapper {
    int deleteByPrimaryKey(String newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
}