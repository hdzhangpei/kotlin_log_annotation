package com.annotation.log.logutil.test

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.domain.ShowParamsWayEnum
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

    @LogPrint(methodType = LogTypeEnum.ENTRANCE, methodDesc = "测试打印出入参", showParamsWay = ShowParamsWayEnum.ALL)
    fun excuteMetodShowAllParams(param1 : List<String?>?, param2: Int?): String? {
        logger.info("当前追踪ID")
        innerService!!.innerMethod(param2)
        return "测试类返回结果" + 99
    }

    @LogPrint(methodType = LogTypeEnum.ENTRANCE, methodDesc = "测试只打印入参", showParamsWay = ShowParamsWayEnum.INPUT)
    fun excuteMetodShowInputParams(param1 : List<String?>?, param2: Int?): String? {
        logger.info("当前追踪ID")
        innerService!!.innerMethod(param2)
        return "测试类返回结果" + 99
    }

    @LogPrint(methodType = LogTypeEnum.ENTRANCE, methodDesc = "测试只打印入参", showParamsWay = ShowParamsWayEnum.OUTPUT)
    fun excuteMetodShowOutputParams(param1 : List<String?>?, param2: Int?): String? {
        logger.info("当前追踪ID")
        innerService!!.innerMethod(param2)
        return "测试类返回结果" + 99
    }
}