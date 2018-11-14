package com.mettre.account.exception;


import com.mettre.account.enum_.ResultEnum;

public class CustomerException extends RuntimeException {
    private String errorCode;

    public CustomerException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

    public CustomerException(String message) {
        super(message);
        this.errorCode = "400";
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}