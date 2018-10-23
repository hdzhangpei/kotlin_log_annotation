package com.annotation.log.logutil.domain

import lombok.Data

/**
 * @ClassName   BaseInfo
 * @Description 工程基础类
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
class BaseInfo {
    /**
     * 线程关键字
     */
    var threadKey : String = ""
}

fun initBaseInfo(logKey: String): BaseInfo {
    var instance = BaseInfo()
    instance.threadKey = logKey

    return instance
}