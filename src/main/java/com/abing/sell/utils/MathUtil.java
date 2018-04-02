package com.abing.sell.utils;

public class MathUtil {

    private static final Double Money_Range=0.01;
    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     */

    public static Boolean equals(Double d1,Double d2){
        Double result=Math.abs(d1-d2);
        if (result<Money_Range)
        {
            return true;
        }else {
            return false;
        }
    }
}
