package com.qiux.tspringboot.service.cache;

/**
 * @author qiux
 * @Date 2022/3/15
 * @since
 */
public class UserCacheConstant {

    private static String PRE_KEY = "tspringboot:";

    public static String key(Integer userId) {
        return PRE_KEY + userId;
    }

}
