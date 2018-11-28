package com.mettre.account.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.pojo.Visitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VisitorMapper {

    int deleteByPrimaryKey(Long visitorId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Long visitorId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> myVisitorPageVo(Page<Visitor> page, @Param(value = "visitorsUesr") String visitorsUesr);

    int deleteAllVisitor(@Param(value = "userId") String userId, @Param(value = "visitorsUesr") String visitorsUesr);

    int deleteAllVisitorFromVisitorId(Long visitorId);
}