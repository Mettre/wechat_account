package com.mettre.account.serviceimpl;

import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.mapper.UserMapper;
import com.mettre.account.pojo.User;
import com.mettre.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public int insert(User record) {
        User user = UserMapper.selectByPrimaryKey(record.getPhone());
        if (user == null) {
            throw new CustomerException(ResultEnum.GOODS_ID_NOT_EMPTY);
        }
        return UserMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
