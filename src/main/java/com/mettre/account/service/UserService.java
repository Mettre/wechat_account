package com.mettre.account.service;

import com.mettre.account.jwt.AccessToken;
import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.ForgetPasswordVM;
import com.mettre.account.pojoVM.ModifyPasswordVM;
import com.mettre.account.pojoVM.UserRegisterVM;
import com.mettre.account.pojoVM.UserVM;

public interface UserService {

    int deleteByPrimaryKey(String userId);

    int insert(UserRegisterVM record);

    int insertSelective(UserVM record);

    User selectByPrimaryKey(String userId);

    AccessToken selectByPhoneAndPassword(String phone, String password);

    int updateByPrimaryKeySelective(UserVM record,String userId);

    int updateByPrimaryKey(UserVM record);

    int forgetPassword(ForgetPasswordVM forgetPasswordVM);

    int modifyPassword(ModifyPasswordVM forgetPasswordVM);
}
