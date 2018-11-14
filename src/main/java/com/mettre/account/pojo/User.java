package com.mettre.account.pojo;

import java.util.Date;

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

    private Integer visitorNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getHeadAvatar() {
        return headAvatar;
    }

    public void setHeadAvatar(String headAvatar) {
        this.headAvatar = headAvatar == null ? null : headAvatar.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBackgroundWall() {
        return backgroundWall;
    }

    public void setBackgroundWall(String backgroundWall) {
        this.backgroundWall = backgroundWall == null ? null : backgroundWall.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(Integer visitorNum) {
        this.visitorNum = visitorNum;
    }
}