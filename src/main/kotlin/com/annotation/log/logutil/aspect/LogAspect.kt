package com.annotation.log.logutil.aspect

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.util.MethodParamsLogFormat
import com.annotation.log.logutil.util.MethodResponseLogFormat
import com.annotation.log.logutil.util.ClearThreadKey
import com.annotation.log.logutil.util.GetThreadKey
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.reflect.Method

/**
 * @ClassName   LogAspect
 * @Description Log切面
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.0
 */
@Aspect  // 切面标识
@Component  // 交给spring容器管理
class LogAspect {
    private val logger = LoggerFactory.getLogger(LogAspect::class.java)
    /**
     * 选取切入点为自定义注解
     */
    @Pointcut("@annotation(com.annotation.log.logutil.annotation.LogPrint)")
    fun logPoint() {}

    @Before(value = "logPoint()")
    fun before(joinPoint: JoinPoint) {
        logger.info(getParamsString(joinPoint))
    }

    @AfterReturning(returning = "response", value = "logPoint()")
    fun afterReturning(joinPoint: JoinPoint, response: Any?) {
        logger.info(MethodResponseLogFormat(GetThreadKey(), getMethod(joinPoint).name, response))
        if (isNeedDelete(joinPoint)) {
            this.deleteThreadKey()
        }
    }

    @AfterThrowing(value = "logPoint()")
    fun afterThrowing(joinPoint: JoinPoint) {
        if (isNeedDelete(joinPoint)) {
            this.deleteThreadKey()
        }
    }

    private fun getMethod(joinPoint: JoinPoint) : Method {
        // 获取连接点的方法签名对象
        val signature = joinPoint.signature as? MethodSignature
                ?: throw Exception("获取被执行对象签名!")
        val target = joinPoint.target
        // 获取到当前执行的方法
        val method = target.javaClass.getMethod(signature.name, *signature.parameterTypes)
        return method
    }

    private fun isNeedDelete(joinPoint: JoinPoint): Boolean {
        // 获取连接点的方法签名对象
        val signature = joinPoint.signature as? MethodSignature
                ?: throw Exception("获取被执行对象签名!")
        val target = joinPoint.target
        // 获取到当前执行的方法
        val method = target.javaClass.getMethod(signature.name, *signature.parameterTypes)
        // 获取方法的注解
        val annotation = method.getAnnotation(LogPrint::class.java!!)

        return LogTypeEnum.ENTRANCE == annotation.type
    }

    fun getParamsString(joinPoint: JoinPoint) : String {
        // 获取连接点的方法签名对象
        val signature = joinPoint.signature as? MethodSignature
                ?: throw Exception("获取被执行对象签名!")
        val target = joinPoint.target
        // 获取到当前执行的方法
        val method = target.javaClass.getMethod(signature.name, *signature.parameterTypes)
        // 获取方法的注解
        val annotation = method.getAnnotation(LogPrint::class.java!!)
        val args = joinPoint.args

        return MethodParamsLogFormat(GetThreadKey(), method.name, annotation.desc, args)
    }

    fun deleteThreadKey() {
        ClearThreadKey()
    }
}