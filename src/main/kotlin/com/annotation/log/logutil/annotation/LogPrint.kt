package com.annotation.log.logutil.annotation

import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.domain.ShowParamsWayEnum
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * @ClassName   LogPrint
 * @Description 日志注解
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @param       methodType 方志类型,入口类方法结束后自动更新业务ID
 * @param       methodDesc 方法描述,日志打印时会显示方法的描述
 * @param       showParamsWay 是否打印出入参
 * @Version     1.3
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(RetentionPolicy.RUNTIME)
annotation class LogPrint(
        val methodType: LogTypeEnum = LogTypeEnum.SERVICE,
        val methodDesc: String = "no method desc",
        val showParamsWay: ShowParamsWayEnum = ShowParamsWayEnum.NONE)