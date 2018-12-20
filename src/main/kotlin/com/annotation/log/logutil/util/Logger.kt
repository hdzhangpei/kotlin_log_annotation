package com.annotation.log.logutil.util

import org.slf4j.LoggerFactory
import org.slf4j.Marker

/**
 * @ClassName Logger
 * @Description 封装Logger类,每个日志加入业务KEY
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Version 1.0
 */
class Logger : org.slf4j.Logger {
    private var log: org.slf4j.Logger? = null

    constructor() {
        log = LoggerFactory.getLogger("Logger")
    }

    constructor(log: org.slf4j.Logger) {
        this.log = log
    }

    override fun getName(): String {
        return log!!.name
    }

    override fun isTraceEnabled(): Boolean {
        return false
    }

    override fun trace(msg: String) {
        log!!.trace(msgWrapper(msg))
    }

    override fun trace(format: String, arg: Any) {
        log!!.trace(msgWrapper(format), arg)
    }

    override fun trace(format: String, arg1: Any, arg2: Any) {
        log!!.trace(msgWrapper(format), arg1, arg2)
    }

    override fun trace(format: String, vararg arguments: Any) {
        log!!.trace(msgWrapper(format), *arguments)
    }

    override fun trace(msg: String, t: Throwable) {
        log!!.trace(msgWrapper(msg), t)
    }

    override fun isTraceEnabled(marker: Marker): Boolean {
        return false
    }

    override fun trace(marker: Marker, msg: String) {
        log!!.trace(marker, msgWrapper(msg))
    }

    override fun trace(marker: Marker, format: String, arg: Any) {
        log!!.trace(marker, msgWrapper(format), arg)
    }

    override fun trace(marker: Marker, format: String, arg1: Any, arg2: Any) {
        log!!.trace(marker, msgWrapper(format), arg1, arg2)
    }

    override fun trace(marker: Marker, format: String, vararg argArray: Any) {
        log!!.trace(marker, msgWrapper(format), *argArray)
    }

    override fun trace(marker: Marker, msg: String, t: Throwable) {
        log!!.trace(marker, msgWrapper(msg), t)
    }

    override fun isDebugEnabled(): Boolean {
        return false
    }

    override fun debug(msg: String) {
        log!!.debug(msgWrapper(msg))
    }

    override fun debug(format: String, arg: Any) {
        log!!.debug(msgWrapper(format), arg)
    }

    override fun debug(format: String, arg1: Any, arg2: Any) {
        log!!.debug(msgWrapper(format), arg1, arg2)
    }

    override fun debug(format: String, vararg arguments: Any) {
        log!!.debug(msgWrapper(format), *arguments)
    }

    override fun debug(msg: String, t: Throwable) {
        log!!.debug(msgWrapper(msg), t)
    }

    override fun isDebugEnabled(marker: Marker): Boolean {
        return false
    }

    override fun debug(marker: Marker, msg: String) {
        log!!.debug(marker, msgWrapper(msg))
    }

    override fun debug(marker: Marker, format: String, arg: Any) {
        log!!.debug(marker, msgWrapper(format), arg)
    }

    override fun debug(marker: Marker, format: String, arg1: Any, arg2: Any) {
        log!!.debug(marker, msgWrapper(format), arg1, arg2)
    }

    override fun debug(marker: Marker, format: String, vararg arguments: Any) {
        log!!.debug(marker, msgWrapper(format), *arguments)
    }

    override fun debug(marker: Marker, msg: String, t: Throwable) {
        log!!.debug(marker, msgWrapper(msg), t)
    }

    override fun isInfoEnabled(): Boolean {
        return false
    }

    override fun info(msg: String) {
        log!!.info(msgWrapper(msg))
    }

    override fun info(format: String, arg: Any) {
        log!!.info(msgWrapper(format), arg)
    }

    override fun info(format: String, arg1: Any, arg2: Any) {
        log!!.info(msgWrapper(format), arg1, arg2)
    }

    override fun info(format: String, vararg arguments: Any) {
        log!!.info(msgWrapper(format), *arguments)
    }

    override fun info(msg: String, t: Throwable) {
        log!!.info(msgWrapper(msg), t)
    }

    override fun isInfoEnabled(marker: Marker): Boolean {
        return false
    }

    override fun info(marker: Marker, msg: String) {
        log!!.info(marker, msgWrapper(msg))
    }

    override fun info(marker: Marker, format: String, arg: Any) {
        log!!.info(marker, msgWrapper(format), arg)
    }

    override fun info(marker: Marker, format: String, arg1: Any, arg2: Any) {
        log!!.info(marker, msgWrapper(format), arg1, arg2)
    }

    override fun info(marker: Marker, format: String, vararg arguments: Any) {
        log!!.info(marker, msgWrapper(format), *arguments)
    }

    override fun info(marker: Marker, msg: String, t: Throwable) {
        log!!.info(marker, msgWrapper(msg), t)
    }

    override fun isWarnEnabled(): Boolean {
        return false
    }

    override fun warn(msg: String) {
        log!!.warn(msgWrapper(msg))
    }

    override fun warn(format: String, arg: Any) {
        log!!.warn(msgWrapper(format), arg)
    }

    override fun warn(format: String, vararg arguments: Any) {
        log!!.warn(msgWrapper(format), *arguments)
    }

    override fun warn(format: String, arg1: Any, arg2: Any) {
        log!!.warn(msgWrapper(format), arg1, arg2)
    }

    override fun warn(msg: String, t: Throwable) {
        log!!.warn(msgWrapper(msg), t)
    }

    override fun isWarnEnabled(marker: Marker): Boolean {
        return false
    }

    override fun warn(marker: Marker, msg: String) {
        log!!.warn(marker, msgWrapper(msg))
    }

    override fun warn(marker: Marker, format: String, arg: Any) {
        log!!.warn(marker, msgWrapper(format), arg)
    }

    override fun warn(marker: Marker, format: String, arg1: Any, arg2: Any) {
        log!!.warn(marker, msgWrapper(format), arg1, arg2)
    }

    override fun warn(marker: Marker, format: String, vararg arguments: Any) {
        log!!.warn(marker, msgWrapper(format), *arguments)
    }

    override fun warn(marker: Marker, msg: String, t: Throwable) {
        log!!.warn(marker, msgWrapper(msg), t)
    }

    override fun isErrorEnabled(): Boolean {
        return false
    }

    override fun error(msg: String) {
        log!!.error(msgWrapper(msg))
    }

    override fun error(format: String, arg: Any) {
        log!!.error(msgWrapper(format), arg)
    }

    override fun error(format: String, arg1: Any, arg2: Any) {
        log!!.error(msgWrapper(format), arg1, arg2)
    }

    override fun error(format: String, vararg arguments: Any) {
        log!!.error(msgWrapper(format), *arguments)
    }

    override fun error(msg: String, t: Throwable) {
        log!!.error(msgWrapper(msg), t)
    }

    override fun isErrorEnabled(marker: Marker): Boolean {
        return false
    }

    override fun error(marker: Marker, msg: String) {
        log!!.error(marker, msgWrapper(msg))
    }

    override fun error(marker: Marker, format: String, arg: Any) {
        log!!.error(marker, msgWrapper(format), arg)
    }

    override fun error(marker: Marker, format: String, arg1: Any, arg2: Any) {
        log!!.error(marker, msgWrapper(format), arg1, arg2)
    }

    override fun error(marker: Marker, format: String, vararg arguments: Any) {
        log!!.error(marker, msgWrapper(format), *arguments)
    }

    override fun error(marker: Marker, msg: String, t: Throwable) {
        log!!.error(marker, msgWrapper(msg), t)
    }

    private fun msgWrapper(msg: String): String {
        return StringBuilder().append(TraceIdUtil.traceId).append(":").append(msg).toString()
    }

}
