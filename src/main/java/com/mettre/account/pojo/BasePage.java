package com.mettre.account.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

@Data
public class BasePage {

    @Min(value = 1, message = "分页入参错误")
    private Integer page;

    @Min(value = 1, message = "分页入参错误")
    private Integer size;
}
