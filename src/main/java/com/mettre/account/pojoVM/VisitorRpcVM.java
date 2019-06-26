package com.mettre.account.pojoVM;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VisitorRpcVM {

    @ApiModelProperty(value = "访问者id")
    private String userId;

    @ApiModelProperty(value = "被访问者id")
    private String visitorsUser;

}
