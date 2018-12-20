package com.annotation.log.logutil.util

import java.util.UUID

/**
 * @ClassName TraceIdUtil
 * @Description 追踪ID工具类
 * @Author pei.zhang
 * @Date 2018-12-20
 * @Version 1.3
 *
 */
object TraceIdUtil {
    private val threadLocal: ThreadLocal<String> = ThreadLocal()

    val traceId: String
        get() {
            var key: String? = threadLocal.get()
            if (null == key) {
                key = traceKey
                set(key)
            }
            return key
        }

    fun clearTraceId() {
        threadLocal.remove()
    }

    private fun set(key: String) {
        threadLocal.set(key)
    }

    private val traceKey: String
        get() = "K" + UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0, 12)
}
