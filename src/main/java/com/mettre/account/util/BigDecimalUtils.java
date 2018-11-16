package com.mettre.account.util;
import java.math.BigDecimal;

public class BigDecimalUtils {

    public static Boolean greaterThanZero(BigDecimal decimal) {

        int r = decimal.compareTo(new BigDecimal(0));
        return r > 0;
    }
}
