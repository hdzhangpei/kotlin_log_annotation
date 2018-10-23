package com.annotation.log.logutil.util;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.util.UUID;

import static com.annotation.log.logutil.util.LogKey.getThreadKey;

/**
 * @ClassName Logger
 * @Description 封装Logger类,每个日志加入业务KEY
 * @Author pei.zhang
 * @Date 2018/10/23
 * @Version 1.0
 */
public class Logger implements org.slf4j.Logger {
    private org.slf4j.Logger log;

    public Logger() {
        log = LoggerFactory.getLogger("Logger");
    }

    public Logger (org.slf4j.Logger log) {
        this.log = log;
    }

    @Override
    public String getName() {
        return log.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String msg) {
        log.trace(msgWrapper(msg));
    }

    @Override
    public void trace(String format, Object arg) {
        log.trace(msgWrapper(format), arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log.trace(msgWrapper(format), arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        log.trace(msgWrapper(format), arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        log.trace(msgWrapper(msg), t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String msg) {
        log.trace(marker, msgWrapper(msg));
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        log.trace(marker, msgWrapper(format), arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log.trace(marker, msgWrapper(format), arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        log.trace(marker, msgWrapper(format), argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        log.trace(marker, msgWrapper(msg), t);
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String msg) {
        log.debug(msgWrapper(msg));
    }

    @Override
    public void debug(String format, Object arg) {
        log.debug(msgWrapper(format), arg);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log.debug(msgWrapper(format), arg1, arg2);
    }

    @Override
    public void debug(String format, Object... arguments) {
        log.debug(msgWrapper(format), arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        log.debug(msgWrapper(msg), t);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String msg) {
        log.debug(marker, msgWrapper(msg));
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        log.debug(marker, msgWrapper(format), arg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log.debug(marker, msgWrapper(format), arg1, arg2);
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        log.debug(marker, msgWrapper(format), arguments);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        log.debug(marker, msgWrapper(msg), t);
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String msg) {
        log.info(msgWrapper(msg));
    }

    @Override
    public void info(String format, Object arg) {
        log.info(msgWrapper(format), arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log.info(msgWrapper(format), arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        log.info(msgWrapper(format), arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        log.info(msgWrapper(msg), t);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String msg) {
        log.info(marker, msgWrapper(msg));
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        log.info(marker, msgWrapper(format), arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log.info(marker, msgWrapper(format), arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        log.info(marker, msgWrapper(format), arguments);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        log.info(marker, msgWrapper(msg), t);
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String msg) {
        log.warn(msgWrapper(msg));
    }

    @Override
    public void warn(String format, Object arg) {
        log.warn(msgWrapper(format), arg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        log.warn(msgWrapper(format), arguments);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log.warn(msgWrapper(format), arg1, arg2);
    }

    @Override
    public void warn(String msg, Throwable t) {
        log.warn(msgWrapper(msg), t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String msg) {
        log.warn(marker, msgWrapper(msg));
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        log.warn(marker, msgWrapper(format), arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log.warn(marker, msgWrapper(format), arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        log.warn(marker, msgWrapper(format), arguments);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        log.warn(marker, msgWrapper(msg), t);
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String msg) {
        log.error(msgWrapper(msg));
    }

    @Override
    public void error(String format, Object arg) {
        log.error(msgWrapper(format), arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log.error(msgWrapper(format), arg1, arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        log.error(msgWrapper(format), arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        log.error(msgWrapper(msg), t);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String msg) {
        log.error(marker, msgWrapper(msg));
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        log.error(marker, msgWrapper(format), arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log.error(marker, msgWrapper(format), arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        log.error(marker, msgWrapper(format), arguments);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        log.error(marker, msgWrapper(msg), t);
    }

    private String msgWrapper(String msg) {
        return new StringBuilder().append("\n").append(getThreadKey()).append(":").append(msg).toString();
    }

}
