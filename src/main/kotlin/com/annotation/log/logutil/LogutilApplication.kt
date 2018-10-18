package com.annotation.log.logutil

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LogutilApplication

fun main(args: Array<String>) {
    SpringApplication.run(LogutilApplication::class.java, *args)
}
