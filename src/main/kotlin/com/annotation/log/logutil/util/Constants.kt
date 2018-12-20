package com.annotation.log.logutil.util

/**
 * @ClassName   Constants
 * @Description 常量类
 * @Author      pei.zhang
 * @Date        2018-12-20
 * @Version     1.3
 */
class Constants {

    enum class Code(var code : Int, var message : String) {
        SUCCESS(10000, "成功");
    }
}