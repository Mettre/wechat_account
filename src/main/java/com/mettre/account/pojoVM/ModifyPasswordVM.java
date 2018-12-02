package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class ModifyPasswordVM {

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Size(min = 6,max = 12,message = "密码格式必须为6-16位")
    private String oldPassword;

    @Size(min = 6,max = 12,message = "密码格式必须为6-16位")
    private String newPassword;

    @NotBlank(message = "验证码不能为空")
    private String captchaCode;
}
