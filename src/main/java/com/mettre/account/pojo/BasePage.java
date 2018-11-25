package com.mettre.account.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class BasePage {

    @NotBlank(message = "分页入参错误")
    private int page;

    @NotBlank(message = "分页入参错误")
    private int size;
}
