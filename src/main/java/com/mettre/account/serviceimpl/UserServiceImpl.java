package com.mettre.account.serviceimpl;

import cn.hutool.core.util.StrUtil;
import com.mettre.account.base.ReturnType;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.enum_.SmsTypeEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.jwt.AccessToken;
import com.mettre.account.jwt.JwtUtils;
import com.mettre.account.mapper.UserMapper;
import com.mettre.account.pojo.User;
import com.mettre.account.pojoVM.ForgetPasswordVM;
import com.mettre.account.pojoVM.ModifyPasswordVM;
import com.mettre.account.pojoVM.UserRegisterVM;
import com.mettre.account.pojoVM.UserVM;
import com.mettre.account.service.RedisService;
import com.mettre.account.service.UserService;
import com.mettre.account.util.AssembleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Value("${spring.tokenExpireTime}")
    private Long tokenExpireTime;

    @Value("${spring.saveLoginTime}")
    private Integer saveLoginTime;


    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public int insert(UserRegisterVM record) {

        if (UserMapper.selectByPhone(record.getPhone()) != null) {
            throw new CustomerException(ResultEnum.REGISTERED);
        }
        String code = redisService.get(AssembleUtils.sendMessageUtils(record.getPhone(),SmsTypeEnum.REGISTER));
        if (StrUtil.isBlank(code)) {
            throw new CustomerException("验证码已过期，请重新获取");
        }
        if (!record.getCaptchaCode().toLowerCase().equals(code.toLowerCase())) {
            throw new CustomerException("验证码不正确");
        }

        User user = new User(record);
        int type = UserMapper.insert(user);
        return ReturnType.ReturnType(type, ResultEnum.REGISTERERROR);
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
    public AccessToken selectByPhoneAndPassword(String phone, String password) {
        User user = UserMapper.selectByPhone(phone);
        if (user == null) {
            throw new CustomerException(ResultEnum.UNREGISTER);
        }
        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new CustomerException(ResultEnum.ACCOUNT_PASSWORD_ERROR);
        }
        return JwtUtils.saveAccessToken(user,tokenExpireTime,saveLoginTime);
    }

    @Override
    public int updateByPrimaryKeySelective(UserVM record, String userId) {

        UserVM.UserVmEmpty(record);
        User user = new User(record, userId);
        int type = UserMapper.updateByPrimaryKeySelective(user);
        return ReturnType.ReturnType(type, ResultEnum.MODIFYUSERINFOERROR);
    }

    @Override
    public int updateByPrimaryKey(UserVM record) {
        return 0;
    }

    @Override
    public int forgetPassword(ForgetPasswordVM forgetPasswordVM) {

        String code = redisService.get(AssembleUtils.sendMessageUtils(forgetPasswordVM.getPhone(),SmsTypeEnum.FORGET_PASSWORD));
        if (StrUtil.isBlank(code)) {
            throw new CustomerException("验证码已过期，请重新获取");
        }
        if (!forgetPasswordVM.getCaptchaCode().toLowerCase().equals(code.toLowerCase())) {
            throw new CustomerException("验证码不正确");
        }
        int type = UserMapper.forgetPassword(new User(forgetPasswordVM));
        return ReturnType.ReturnType(type, ResultEnum.FORGET_PASSWORD);
    }

    @Override
    public int modifyPassword(ModifyPasswordVM modifyPasswordVM) {
        String code = redisService.get(AssembleUtils.sendMessageUtils(modifyPasswordVM.getPhone(),SmsTypeEnum.MODIFY_PASSWORD));
        if (StrUtil.isBlank(code)) {
            throw new CustomerException("验证码已过期，请重新获取");
        }
        if (!modifyPasswordVM.getCaptchaCode().toLowerCase().equals(code.toLowerCase())) {
            throw new CustomerException("验证码不正确");
        }
        User user = UserMapper.selectByPhone(modifyPasswordVM.getPhone());
        if (user==null||!new BCryptPasswordEncoder().matches(modifyPasswordVM.getOldPassword(), user.getPassword())) {
            throw new CustomerException("老密码错误");
        }

        int type = UserMapper.forgetPassword(new User(modifyPasswordVM));
        return ReturnType.ReturnType(type, ResultEnum.FORGET_PASSWORD);
    }
}
