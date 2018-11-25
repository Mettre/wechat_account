package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class FollowVM {

    @NotBlank(message = "关注人不能为空")
    private String userId;

    @NotBlank(message = "被关注人不能为空")
    private String followedUser;

}
