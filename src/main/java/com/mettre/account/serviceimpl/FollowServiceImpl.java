package com.mettre.account.serviceimpl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.account.base.ReturnType;
import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;
import com.mettre.account.mapper.FollowMapper;
import com.mettre.account.pojo.Follow;
import com.mettre.account.pojoVM.FollowVM;
import com.mettre.account.service.FollowService;
import com.mettre.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {

    @Autowired
    public FollowMapper followMapper;

    @Autowired
    public UserService userService;

    @Override
    public int deleteByPrimaryKey(Long followId) {
        return 0;
    }

    @Override
    public int insert(FollowVM followVM) {

        int type = 0;
        Follow follow = followMapper.findWhetherFollow(new Follow(followVM));
        if (follow != null) {
            if (follow.getStatus()) {
                throw new CustomerException(ResultEnum.HAVEDFOLLOWED);
            }
            type = followMapper.addFollow(new Follow(followVM));
        } else {
            userService.selectByPrimaryKey(followVM.getUserId());
            userService.selectByPrimaryKey(followVM.getFollowedUser());
            type = followMapper.insert(new Follow(followVM));
        }

        return ReturnType.ReturnType(type, ResultEnum.FOLLOWERROR);

    }

    @Override
    public int insertSelective(Follow record) {
        return 0;
    }

    @Override
    public Follow selectByPrimaryKey(Long followId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Follow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Follow record) {
        return 0;
    }

    @Override
    public int cancelFollow(FollowVM followVM) {
        Follow follow = followMapper.findWhetherFollow(new Follow(followVM));
        if (follow == null) {
            throw new CustomerException(ResultEnum.CANCELFOLLOW);
        }
        int type = followMapper.cancelFollow(new Follow(followVM));
        return ReturnType.ReturnType(type, ResultEnum.CANCELFOLLOW);
    }

    @Override
    public Follow findWhetherFollow(FollowVM followVM) {

        return followMapper.findWhetherFollow(new Follow(followVM));
    }

    @Override
    public Page<Follow> myFollowPageVo(Page<Follow> page, String userId) {
        List<Follow> followList = (List<Follow>) followMapper.myFollowPageVo(page, userId);
        if (followList != null && followList.size() > 0) {
            for (Follow follow : followList) {
                follow.setEachOther(StrUtil.isNotBlank(follow.getUserId2()));
            }
        }
        page = page.setRecords(followList);
        return page;
    }

    @Override
    public Page<Follow> myFansPageVo(Page<Follow> page, String userId) {
        List<Follow> followList = (List<Follow>) followMapper.myFansPageVo(page, userId);
        if (followList != null && followList.size() > 0) {
            for (Follow follow : followList) {
                follow.setEachOther(StrUtil.isNotBlank(follow.getUserId2()));
            }
        }
        page = page.setRecords(followList);
        return page;
    }

    @Override
    public Page<Follow> myFriendsPageVo(Page<Follow> page, String userId) {
        List<Follow> followList = (List<Follow>) followMapper.myFriendsPageVo(page, userId);
        page = page.setRecords(followList);
        return page;
    }
}