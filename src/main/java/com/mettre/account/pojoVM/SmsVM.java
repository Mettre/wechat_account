package com.mettre.account.pojoVM;

import com.mettre.account.enum_.SmsTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class SmsVM  {

    @ApiModelProperty(value = "短信类型")
    private SmsTypeEnum smsType;

    @NotBlank(message = "发送手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String smsPhone;

    @NotBlank(message = "短信内容不能为空")
    @ApiModelProperty(value = "验证码")
    private String smsContent;
}
