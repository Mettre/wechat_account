package com.mettre.account.pojo;

import com.mettre.account.pojoVM.FollowVM;
import lombok.Data;

import java.util.Date;


@Data
public class Follow {

    private Long followId;

    private String userId;

    private String followedUser;

    private Boolean status;

    private Date creationTime;

    private Date updateTime;

    private String userName;

    private String followedUserName;

    public Follow() {

    }


    //新增关注
    public Follow(FollowVM followVM) {
        this.userId = followVM.getUserId();
        this.followedUser = followVM.getFollowedUser();
        this.status = true;
        this.creationTime = new Date();
        this.updateTime = new Date();
    }


}