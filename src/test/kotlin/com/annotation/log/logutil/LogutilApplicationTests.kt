package com.annotation.log.logutil

import com.annotation.log.logutil.test.TestService
import com.annotation.log.logutil.util.LogKey.getThreadKey
import com.annotation.log.logutil.util.LoggerFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class LogutilApplicationTests {
    val logger = LoggerFactory.getLogger(LogutilApplicationTests :: class.java)
    @Autowired
    val testService : TestService? = null

    @Test
    fun test() {
        val key : String = getThreadKey()
        try {

            testService!!.excuteMetod(null, null)
            Assert.assertFalse(key.equals(getThreadKey()))

            testService!!.excuteMetod("777", "888")
            Assert.assertFalse(key.equals(getThreadKey()))
        } catch (e : Exception) {
            logger.error("errorsss", e)
            Assert.assertTrue(key.equals(getThreadKey()))
            testService!!.excuteMetod("777", "888")
            Assert.assertFalse(key.equals(getThreadKey()))
        }
    }

}
