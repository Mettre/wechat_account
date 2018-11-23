package com.mettre.account.serviceimpl;

import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.mapper.UserMapper;
import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.UserVM;
import com.mettre.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public int insert(UserVM record) {
        if (UserMapper.selectByPhone(record.getPhone()) != null) {
            throw new CustomerException(ResultEnum.REGISTERED);
        }
        User user = new User(record);
        return UserMapper.insert(user);
    }

    @Override
    public int insertSelective(UserVM record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        User user = UserMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new CustomerException(ResultEnum.USERIDNOT);
        }
        return user;
    }

    @Override
    public User selectByPhoneAndPassword(String phone, String password) {
        User user = UserMapper.selectByPhone(phone);
        if (user == null) {
            throw new CustomerException(ResultEnum.UNREGISTER);
        }
        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new CustomerException(ResultEnum.ACCOUNT_PASSWORD_ERROR);
        }
        return new User(user);
    }


    @Override
    public int updateByPrimaryKeySelective(UserVM record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserVM record) {
        return 0;
    }
}
