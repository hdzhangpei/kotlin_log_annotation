package com.annotation.log.logutil.util


/**
 * @ClassName LoggerFactory
 * @Description 代理LoggerFactory类
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Modified 2019-1-5
 * @Version 1.4
 */
@Deprecated("please use MDC binging traceId")
object LoggerFactory {

    private var logger: org.slf4j.Logger? = null
    @JvmStatic fun getLogger(clazz: Class<*>): Logger {
        logger = org.slf4j.LoggerFactory.getLogger(clazz)
        val log : Logger = Logger(logger!!)
        return log
    }
}
