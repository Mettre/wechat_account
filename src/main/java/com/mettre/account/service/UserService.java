package com.mettre.account.service;

import com.mettre.account.pojoVM.UserVM;

public interface UserService {

    int deleteByPrimaryKey(String userId);

    int insert(UserVM record);

    int insertSelective(UserVM record);

    UserVM selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserVM record);

    int updateByPrimaryKey(UserVM record);
}
