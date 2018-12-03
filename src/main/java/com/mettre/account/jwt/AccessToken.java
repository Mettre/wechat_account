package com.mettre.account.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessToken implements Serializable {

    private String access_token;
    private String token_type;
    private long expires_in;
    private String userId;

    public AccessToken() {
    }

    public AccessToken(String userId) {
        this.userId = userId;
    }

    public AccessToken(String access_token, String token_type, long expires_in,String userId) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.userId = userId;
    }
}
