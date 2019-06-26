package com.mettre.account.serviceimpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.ReturnType;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.jwt.SecurityContextStore;
import com.mettre.account.mapper.VisitorMapper;
import com.mettre.account.pojo.User;
import com.mettre.account.pojo.Visitor;
import com.mettre.account.service.UserService;
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

    @Autowired
    public UserService userService;


    @Override
    public int deleteByPrimaryKey(Long visitorId) {

        int type = visitorMapper.deleteByPrimaryKey(visitorId);
        return ReturnType.ReturnType(type, ResultEnum.VISTORDELETEERROY);
    }

    @Override
    public int insert(Visitor record) {
        int type = 0;
        if (!record.getUserId().equals(record.getVisitorsUser())) {
            User user1 = userService.selectByPrimaryKey(record.getUserId());
            User user2 = userService.selectByPrimaryKey(record.getVisitorsUser());
            if (user1 == null || user2 == null) {
                throw new CustomerException(ResultEnum.VISTORERROY);
            }
            type = visitorMapper.insert(record);
        }
        return ReturnType.ReturnType(type, ResultEnum.VISTORERROY);
    }

    @Override
    public int insertSelective(Visitor record) {
        return 0;
    }

    @Override
    public Visitor selectByPrimaryKey(Long visitorId) {

        return (Visitor) ReturnType.ReturnType(visitorMapper.selectByPrimaryKey(visitorId), ResultEnum.VISTORSELECTERROY);
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

    @Override
    public int deleteAllVisitorFromVisitorId(Long visitorId) {
        String userId = SecurityContextStore.getContext().getUserId();
        Visitor visitor = selectByPrimaryKey(visitorId);
        if (!userId.equals(visitor.getVisitorsUser())) {
            throw new CustomerException("无权删除");
        }
        int type = visitorMapper.deleteAllVisitorFromVisitorId(visitorId);
        return ReturnType.ReturnType(type, ResultEnum.VISTORDELETEERROY);
    }

    @Override
    public int deleteAllVisitor(String userId, String visitorsUesr) {
        int type = visitorMapper.deleteAllVisitor(userId, visitorsUesr);
        return ReturnType.ReturnType(type, ResultEnum.VISTORDELETEERROY);
    }
}
