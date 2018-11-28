package com.mettre.account.pojoVM;

import com.mettre.account.enum_.SmsTypeEnum;
import com.mettre.account.pojo.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SmsSearchVm extends BasePage {

    @ApiModelProperty(value = "短信类型")
    private SmsTypeEnum smsType;

    @ApiModelProperty(value = "手机号")
    private String smsPhone;
}
