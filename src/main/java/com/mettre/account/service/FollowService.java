package com.mettre.account.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.ResultList;
import com.mettre.account.pojo.Follow;
import com.mettre.account.pojoVM.FollowVM;

public interface FollowService {

    int deleteByPrimaryKey(Long followId);

    int insert(FollowVM followVM);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Long followId);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    int cancelFollow(FollowVM followVM);

    Follow findWhetherFollow(FollowVM record);

    Page<Follow> myFollowPageVo(Page<Follow> page,String userId);

    Page<Follow> myFansPageVo(Page<Follow> page, String userId);

    Page<Follow> myFriendsPageVo(Page<Follow> page, String userId);

    ResultList myFriendsList(String userId);

}
