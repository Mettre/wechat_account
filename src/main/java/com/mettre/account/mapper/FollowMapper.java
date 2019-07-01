package com.mettre.account.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.pojo.FindUser;
import com.mettre.account.pojo.Follow;
import com.mettre.account.pojo.Friends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FollowMapper {

    int deleteByPrimaryKey(Long followId);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Long followId);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    int cancelFollow(Follow record);

    int addFollow(Follow record);

    Follow findWhetherFollow(Follow record);

    List<Follow> myFollowPageVo(Page<Follow> page, @Param(value = "userId") String userId);

    List<Follow> myFansPageVo(Page<Follow> page, @Param(value = "userId") String userId);

    List<Follow> myFriendsPageVo(Page<Follow> page, @Param(value = "userId") String userId);

    List<Friends> myFriendsList(@Param(value = "userId") String userId);

    List<FindUser> findUserList(@Param(value = "userId") String userId, @Param(value = "findUserId") String findUserId);
}