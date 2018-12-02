package com.mettre.account.pojoVM;

import com.mettre.account.enum_.GenderEnum;
import com.mettre.account.exception.CustomerException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class UserVM {

    @ApiModelProperty(value = "昵称")
    private String userName;

    private String signature;

    private GenderEnum gender;

    private String headAvatar;

    private String city;

    @Min(value = 1, message = "年龄不能为空")
    private Integer age;

    private String backgroundWall;

    public static Boolean UserVmEmpty(UserVM userVM) {
        boolean type = true;
        if (userVM.getGender() != null) {
            if (!GenderEnum.contains(userVM.getGender().name())) {
                throw new CustomerException("性别错误");
            }
        }

        if (userVM.getAge() != null) {
            if (userVM.getAge() < 1 || userVM.getAge() > 99) {
                throw new CustomerException("年龄必须满足1-99之间");
            }
        }
        return type;
    }

}
