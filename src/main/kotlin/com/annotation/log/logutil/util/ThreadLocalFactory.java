package com.annotation.log.logutil.util;

/**
 * @ClassName ThreadLocalFactory
 * @Description TODO
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Version 1.0
 */
public class ThreadLocalFactory {
    private final ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static ThreadLocal<String> getCurrentTreadLocal() {
        return null;
    }
}
