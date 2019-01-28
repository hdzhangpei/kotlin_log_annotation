package com.annotation.log.logutil.domain

import com.annotation.log.logutil.util.Constants
import com.annotation.log.logutil.util.TraceUtil
import java.io.Serializable

/**
 * @ClassName ResultDto
 * @Description 结果包装
 * @Author pei.zhang
 * @Date 2018/10/24
 * @Version 1.0
 */
class Result<T> : Serializable {
    private val serialVersionUID = 1L

    var isSuccess: Boolean = false
    var code : Int = Constants.Code.SUCCESS.code
    var message: String? = null
    var traceId = TraceUtil.getTrace()
    var data: T? = null

    constructor(success: Boolean) {
        this.isSuccess = success
    }

    constructor(success: Boolean, code: Int, message: String?) {
        this.code = code
        this.isSuccess = success
        this.message = message
    }
}
