@file:JvmName("LogKey")
package com.annotation.log.logutil.util

import com.annotation.log.logutil.domain.BaseInfo
import com.annotation.log.logutil.domain.initBaseInfo
import java.util.*

/**
 * @ClassName   LogKey
 * @Description 日志关键字
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
private val threadLocal = ThreadLocal<BaseInfo>()

fun GetThreadKey(): String {
    var info: BaseInfo? = threadLocal.get()
    if (null == info) {
        info = initBaseInfo(getLogKey())
        set(info)
    }
    return info.threadKey
}

fun ClearThreadKey() {
    threadLocal.remove()
}

private fun set(base: BaseInfo) {
    threadLocal.set(base)
}

private fun getLogKey(): String {
    return "K" + UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0, 12)
}