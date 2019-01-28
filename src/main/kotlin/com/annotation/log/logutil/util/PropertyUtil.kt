package com.xstore.period.util

import org.slf4j.LoggerFactory

import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Properties

/**
 * @ClassName PropertyUtil
 * @Description 属性文件工具
 * @Author pei.zhang
 * @Date 2018/7/13
 * @Version 1.0
 */
object PropertyUtil {
    private val logger = LoggerFactory.getLogger(PropertyUtil::class.java)
    private var props: Properties? = null

    init {
        loadProps()
    }

    @Synchronized
    private fun loadProps() {
        logger.info("load properties start.")
        props = Properties()
        var `in`: InputStream? = null
        try {
            `in` = PropertyUtil::class.java.classLoader.getResourceAsStream("functionKey.properties")
            props!!.load(InputStreamReader(`in`!!))
        } catch (e: FileNotFoundException) {
            logger.error("messages.properties is not found.")
        } catch (e: IOException) {
            logger.error("load messages.properties IOException.")
        } finally {
            try {
                `in`?.close()
            } catch (e: IOException) {
                logger.error("close messages.properties IOException.")
            }

        }
        logger.info("load properties success.")
    }

    fun getProperty(key: String): String? {
        if (null == props) {
            loadProps()
        }
        return props!!.getProperty(key)
    }

    fun getProperty(key: String, defaultValue: String): String? {
        if (null == props) {
            loadProps()
        }
        return props!!.getProperty(key, defaultValue)
    }

}
