@file:JvmName("LogFormatUtils")
package com.annotation.log.logutil.util

/**
 * @ClassName   LogFormatUtils
 * @Description 日志格式化工具
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
fun LogFormat(vararg params : Any) : String {
    val sb = StringBuilder()
    for ((index, i) in params.withIndex()) {
        if (index % 2 == 0) {
            sb.append("\n").append(params.get(index)).append(":")
        } else {
            sb.append("\n").append("[").append(params.get(index)).append("]")
        }
    }
    return sb.toString()
}

fun MethodParamsLogFormat(logKey : String, methodName : String, methodDesc : String, params : Array<Any>?) : String {
    val sb = StringBuilder()
    sb.append("\n").append("INPUT:Key").append("[").append(logKey).append("]")
            .append("-MethodName").append("[").append(methodName).append("]")
            .append("-MethodDesc").append("[").append(methodDesc).append("]")

    params?.forEach { param ->
        sb.append("\n").append("[").append(param?.toString()).append("]")
    }

    return sb.toString()
}

fun MethodResponseLogFormat(logKey : String, methodName : String, response : Any?) : String {
    val sb = StringBuilder()
    sb.append("\n").append("OUTPUT:Key").append("[").append(logKey).append("]")
            .append("-MethodName").append("[").append(methodName).append("]")
            .append("-Data").append("[").append(response).append("]")

    return sb.toString()
}