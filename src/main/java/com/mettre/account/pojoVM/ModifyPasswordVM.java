package com.mettre.account.pojoVM;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class ModifyPasswordVM {

    @Size(min = 6,max = 12,message = "密码格式必须为6-16位")
    private String oldPassword;

    @Size(min = 6,max = 12,message = "密码格式必须为6-16位")
    private String newPassword;
}
