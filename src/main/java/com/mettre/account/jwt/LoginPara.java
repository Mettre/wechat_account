package com.mettre.account.jwt;

import lombok.Data;

@Data
public class LoginPara {

    private String clientId;
    private String userName;
    private String password;
}
