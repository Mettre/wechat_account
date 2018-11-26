package com.mettre.account.service;

import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.UserVM;

public interface UserService {

    int deleteByPrimaryKey(String userId);

    int insert(UserVM record);

    int insertSelective(UserVM record);

    User selectByPrimaryKey(String userId);

    User selectByPhoneAndPassword(String phone, String password);

    int updateByPrimaryKeySelective(UserVM record,String userId);

    int updateByPrimaryKey(UserVM record);
}
