package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CategoryVM {

    @NotBlank(message = "分类名称不能为空")
    private String categoryName;

    private boolean isShow = true;

}
