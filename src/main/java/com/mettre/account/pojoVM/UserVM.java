package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserVM {

    private String userId;

    private String userName;

    private String signature;

    private String gender;

    private String headAvatar;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    private String city;

    private Integer age;

    private String backgroundWall;
}
