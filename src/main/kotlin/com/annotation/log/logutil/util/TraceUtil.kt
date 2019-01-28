package com.annotation.log.logutil.util

import java.util.UUID

/**
 * @ClassName TraceUtil
 * @Description 追踪ID工具类
 * @Author pei.zhang
 * @Date 2018-12-20
 * @Version 1.3
 *
 */
object TraceUtil {
    private val threadLocal: ThreadLocal<MutableMap<String, String>> = ThreadLocal()
    private val TRACE_ID : String = "traceId"
    private val FUNCTION_KEY : String = "functionKey"

    @JvmStatic fun getTrace(): String {
        var keyMap: MutableMap<String, String>? = threadLocal.get()
        if (null == keyMap) {
            keyMap = mutableMapOf()
            keyMap[TRACE_ID] = traceKey
            set(keyMap)
        } else {
            var traceId = keyMap[TRACE_ID]
            if (null == traceId) {
                keyMap[TRACE_ID] = traceKey
            }
        }
        return keyMap.get(TRACE_ID)!!
    }

    @JvmStatic fun clearTrace() {
        threadLocal.remove()
    }

    @JvmStatic fun putTrace(key: String) {
        var keyMap: MutableMap<String, String>? = threadLocal.get()
        if (null == keyMap) {
            keyMap = mutableMapOf()
            keyMap[TRACE_ID] = key
            set(keyMap)
        } else {
            keyMap[TRACE_ID] = key
        }
    }

    private fun set(keyMap: MutableMap<String, String>) {
        threadLocal.set(keyMap)
    }

    private val traceKey: String
        get() = "T" + UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0, 12)
}
