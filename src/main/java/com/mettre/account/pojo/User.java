package com.mettre.account.pojo;

import cn.hutool.core.util.StrUtil;
import com.mettre.account.enum_.GenderEnum;
import com.mettre.account.pojoVM.ForgetPasswordVM;
import com.mettre.account.pojoVM.ModifyPasswordVM;
import com.mettre.account.pojoVM.UserRegisterVM;
import com.mettre.account.pojoVM.UserVM;
import com.mettre.account.util.RandomUtil;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Data
public class User {

    private String userId;

    private String userName;

    private String signature;

    private GenderEnum gender;

    private String headAvatar;

    private String password;

    private String phone;

    private String city;

    private Integer age;

    private String backgroundWall;

    private Date creationTime;

    private Date updateTime;

    public User() {
    }

    //修改用户信息
    public User(UserVM userVM, String userId) {
        this.userId = userId;
        this.userName = userVM.getUserName();
        this.signature = userVM.getSignature();
        this.gender = userVM.getGender();
        this.headAvatar = userVM.getHeadAvatar();
        this.city = userVM.getCity();
        this.age = userVM.getAge();
        this.backgroundWall = userVM.getBackgroundWall();
        this.updateTime = new Date();
    }

    //忘记密码
    public User(ForgetPasswordVM forgetPasswordVM) {
        this.password = StrUtil.isBlank(forgetPasswordVM.getPassword()) ? null : new BCryptPasswordEncoder().encode(forgetPasswordVM.getPassword().trim());
        this.phone = forgetPasswordVM.getPhone();
        this.updateTime = new Date();
    }

    //修改密码
    public User(ModifyPasswordVM modifyPasswordVM) {
        this.password = StrUtil.isBlank(modifyPasswordVM.getNewPassword()) ? null : new BCryptPasswordEncoder().encode(modifyPasswordVM.getNewPassword().trim());
        this.phone = modifyPasswordVM.getPhone();
        this.updateTime = new Date();
    }

    //个人信息没有密码
    public User(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.signature = user.getSignature();
        this.gender = user.getGender();
        this.headAvatar = user.getHeadAvatar();
        this.phone = user.getPhone();
        this.city = user.getCity();
        this.age = user.getAge();
        this.backgroundWall = user.getBackgroundWall();
        this.creationTime = user.creationTime;
    }

    //注册
    public User(UserRegisterVM userVM) {
        this.userId = RandomUtil.generateUserId();
        this.userName = RandomUtil.generateNickName();
        this.password = new BCryptPasswordEncoder().encode(userVM.getPassword().trim());
        this.phone = userVM.getPhone();
        this.creationTime = new Date();
        this.updateTime = new Date();
    }
}