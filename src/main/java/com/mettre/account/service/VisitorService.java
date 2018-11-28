package com.mettre.account.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.pojo.Visitor;

public interface VisitorService {

    int deleteByPrimaryKey(Long visitorId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Long visitorId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    Page<Visitor> myVisitorPageVo(Page<Visitor> page, String visitorsUesr);

    int deleteAllVisitorFromVisitorId(Long visitorId);

    int deleteAllVisitor(String userId, String visitorsUesr);
}
