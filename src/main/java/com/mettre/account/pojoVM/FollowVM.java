package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class FollowVM {

    @NotBlank(message = "被关注人不能为空")
    private String followedUser;

}
