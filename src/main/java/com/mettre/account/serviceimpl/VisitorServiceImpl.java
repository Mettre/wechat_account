package com.mettre.account.serviceimpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.ReturnType;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.mapper.VisitorMapper;
import com.mettre.account.pojo.Visitor;
import com.mettre.account.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    public VisitorMapper visitorMapper;


    @Override
    public int deleteByPrimaryKey(Long visitorId) {
        return 0;
    }

    @Override
    public int insert(Visitor record) {

        int type = visitorMapper.insert(record);
        return ReturnType.ReturnType(type, ResultEnum.VISTORERROY);
    }

    @Override
    public int insertSelective(Visitor record) {
        return 0;
    }

    @Override
    public Visitor selectByPrimaryKey(Long visitorId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Visitor record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Visitor record) {
        return 0;
    }

    @Override
    public Page<Visitor> myVisitorPageVo(Page<Visitor> page, String visitorsUesr) {
        List<Visitor> visitorList = (List<Visitor>) visitorMapper.myVisitorPageVo(page, visitorsUesr);
        page = page.setRecords(visitorList);
        return page;
    }
}
