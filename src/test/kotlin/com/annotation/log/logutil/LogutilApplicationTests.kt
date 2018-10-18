package com.annotation.log.logutil

import com.annotation.log.logutil.test.TestService
import com.annotation.log.logutil.util.GetThreadKey
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class LogutilApplicationTests {

    @Autowired
    val testService : TestService? = null

    @Test
    fun test() {
        val key : String = GetThreadKey()
        testService!!.excuteMetod(null, null)
        Assert.assertFalse(key.equals(GetThreadKey()))
    }

}
