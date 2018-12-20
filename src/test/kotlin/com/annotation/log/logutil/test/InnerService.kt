package com.annotation.log.logutil.test

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.util.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @ClassName   InnerService
 * @Description 测试内部服务类
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
@Component
class InnerService {
    private val logger = LoggerFactory.getLogger(InnerService::class.java)
    @LogPrint(methodDesc = "内部测试类")
    fun innerMethod(param : Int?) : String? {
        logger.info("当前追踪ID")
        return "内部测试类返回参数" + param
    }
}