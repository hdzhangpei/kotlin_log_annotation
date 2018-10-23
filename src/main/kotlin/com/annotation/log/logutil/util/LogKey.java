package com.annotation.log.logutil.util;

import java.util.UUID;

/**
 * @ClassName LogKey
 * @Description TODO
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Version 1.0
 */
public class LogKey {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal();

    public static String getThreadKey() {
        String key = threadLocal.get();
        if (null == key) {
            key = getLogKey();
            set(key);
        }
        return key;
    }

    public static void clearThreadKey() {
        threadLocal.remove();
    }

    private static void set(String key) {
        threadLocal.set(key);
    }

    private static String getLogKey() {
        return "K" + UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0, 12);
    }
}
