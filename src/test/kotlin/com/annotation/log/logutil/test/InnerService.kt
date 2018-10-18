package com.annotation.log.logutil.test

import com.annotation.log.logutil.annotation.LogPrint
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
    @LogPrint(desc = "内部测试类")
    fun innerTest(param : Int?) : Long? {
        return null
    }
}