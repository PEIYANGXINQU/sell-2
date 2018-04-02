package com.abing.sell.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * Created by Administrator on 2017/10/15 0015.
 */
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
