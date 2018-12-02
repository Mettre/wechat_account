package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ForgetPasswordVM {

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Min(value = 6, message = "密码格式必须为6-16位")
    @Max(value = 16, message = "密码格式必须为6-16位")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String captchaCode;
}
