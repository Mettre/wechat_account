package com.mettre.account.pojoVM;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VisitorVM {

    @ApiModelProperty(value = "被访问者id")
    private String visitorsUesr;
}
