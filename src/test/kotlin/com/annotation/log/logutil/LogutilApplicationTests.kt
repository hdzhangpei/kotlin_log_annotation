package com.annotation.log.logutil

import com.annotation.log.logutil.test.TestService
import com.annotation.log.logutil.util.LoggerFactory
import com.annotation.log.logutil.util.TraceUtil
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class LogutilApplicationTests {
    val logger = LoggerFactory.getLogger(LogutilApplicationTests :: class.java)
    @Autowired
    val testService : TestService? = null

    @Test
    fun test_show_all_params() {
        val key : String = TraceUtil.getTrace()
        try {

            testService!!.excuteMetodShowAllParams(Arrays.asList(null, "标"), 11)
            logger.info("当前追踪ID")
            Assert.assertFalse(key.equals(TraceUtil.getTrace()))
        } catch (e : Exception) {
            logger.error("errorsss", e)
        }
    }

    @Test
    fun test_show_input_params() {
        val key : String = TraceUtil.getTrace()
        try {
            testService!!.excuteMetodShowInputParams(Arrays.asList(null, "标"), 22)
            logger.info("当前追踪ID")
            Assert.assertFalse(key.equals(TraceUtil.getTrace()))
        } catch (e : Exception) {
            logger.error("errorsss", e)
        }
    }

    @Test
    fun test_show_output_params() {
        val key : String = TraceUtil.getTrace()
        try {
            testService!!.excuteMetodShowOutputParams(Arrays.asList(null, "标"), 33)
            logger.info("当前追踪ID")
            Assert.assertFalse(key.equals(TraceUtil.getTrace()))
        } catch (e : Exception) {
            logger.error("errorsss", e)
        }
    }

}
