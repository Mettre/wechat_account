package com.mettre.account.pojo;

import cn.hutool.core.util.StrUtil;
import com.mettre.account.pojoVM.UserVM;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class User {

    private String userId;

    private String userName;

    private String signature;

    private String gender;

    private String headAvatar;

    private String password;

    private String phone;

    private String city;

    private Integer age;

    private String backgroundWall;

    private Date creationTime;

    private Date updateTime;

    public User(String userId, String userName, String signature, String gender, String headAvatar, String password, String phone, String city, Integer age, String backgroundWall, Date creationTime, Date updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.signature = signature;
        this.gender = gender;
        this.headAvatar = headAvatar;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.age = age;
        this.backgroundWall = backgroundWall;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    //注册
    public User(UserVM userVM) {
        this.userId = UUID.randomUUID().toString().replaceAll("-","");
        this.userName = userVM.getUserName();
        this.signature = userVM.getSignature();
        this.gender = userVM.getGender();
        this.headAvatar = userVM.getHeadAvatar();
        this.password = userVM.getPassword();
        this.phone = userVM.getPhone();
        this.city = userVM.getCity();
        this.age = userVM.getAge();
        this.backgroundWall = userVM.getBackgroundWall();
        this.creationTime = new Date();
        this.updateTime = new Date();
    }
}