package com.annotation.log.logutil.annotation

import com.annotation.log.logutil.domain.LogTypeEnum
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * @ClassName   LogPrint
 * @Description 日志注解
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(RetentionPolicy.RUNTIME)
annotation class LogPrint(val type: LogTypeEnum = LogTypeEnum.SERVICE, val desc: String = "")