package com.mettre.account.mapper;

import com.mettre.account.pojo.Visitor;

public interface VisitorMapper {
    int deleteByPrimaryKey(String visitorId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(String visitorId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}