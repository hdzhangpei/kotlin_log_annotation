package com.annotation.log.logutil.test

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.util.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @ClassName   TestService
 * @Description 测试服务
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
@Service
class TestService {
    private val logger = LoggerFactory.getLogger(TestService::class.java)

    @Autowired
    val innerService : InnerService? = null

    @LogPrint(type = LogTypeEnum.ENTRANCE, desc = "目标测试方法")
    fun excuteMetod(param1 : String?, param2: String?): String? {
//        var i = 1/0
        innerService!!.innerTest(null)
        return null
    }
}