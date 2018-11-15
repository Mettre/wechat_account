package com.mettre.account.jwt;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TokenObject {

    /**
     * 客户端id
     */
    private String clientId;
    /**
     * base64加密
     */
    private String base64Secret;
    /**
     * 用户名
     */
    private String name;
    /**
     * 到期时间
     */
    private long expiresSecond;
    /**
     * 管理员名称
     */
    private String userName;
    /**
     * 管理员id
     */
    private Integer aId;
    /**
     * 职能
     */
    private String role;
    /**
     * 项目名称
     */
    private String project;
}
