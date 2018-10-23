package com.annotation.log.logutil.util;

import org.slf4j.Logger;

/**
 * @ClassName LoggerFactory
 * @Description TODO
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Version 1.0
 */
public class LoggerFactory {

    private static Logger logger;
    public static com.annotation.log.logutil.util.Logger getLogger(Class<?> clazz) {
        logger = org.slf4j.LoggerFactory.getLogger(clazz);
        com.annotation.log.logutil.util.Logger log = new com.annotation.log.logutil.util.Logger(logger);
        return log;
    }
}
