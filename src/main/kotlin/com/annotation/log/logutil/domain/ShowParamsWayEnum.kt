package com.annotation.log.logutil.domain

/**
 * @ClassName   ShowParamsWayEnum
 * @Description 日志显示参数方式
 * @Author      pei.zhang
 * @Date        2018/12/20
 * @Version     1.3
 */
enum class ShowParamsWayEnum {
    /**
     * 不打印
     */
    NONE,
    /**
     * 出入参均打印
     */
    ALL,
    /**
     * 入参
     */
    INPUT,
    /**
     * 出参
     */
    OUTPUT,
    /**
     * 入参打印注解标记的字段
     */
    INPUT_CUSTOM,
    /**
     * 出参打印注解标记的字段
     */
    OUTPUT_CUSTOM;
}