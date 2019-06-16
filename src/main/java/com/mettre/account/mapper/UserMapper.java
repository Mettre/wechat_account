package com.mettre.account.mapper;

import com.mettre.account.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    User selectByPhoneAndPassword(@Param(value = "phone")String phone, @Param(value = "password")String password);

    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int forgetPassword(User record);

    int modifyPassword(User user);
}