package com.mettre.account.base;

import com.mettre.account.enum_.ResultEnum;
import com.mettre.account.exception.CustomerException;

public class ReturnType {

    public static int ReturnType(int type, ResultEnum resultEnum) {
        if (type < 1) {
            throw new CustomerException(resultEnum);
        }
        return type;
    }

    public static Object ReturnType(Object object, ResultEnum resultEnum) {
        if (object ==null) {
            throw new CustomerException(resultEnum);
        }
        return object;
    }
}
