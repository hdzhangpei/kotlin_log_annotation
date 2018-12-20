package com.annotation.log.logutil.aspect

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.domain.ShowParamsWayEnum
import com.annotation.log.logutil.util.Logger
import com.annotation.log.logutil.util.LoggerFactory
import com.annotation.log.logutil.util.TraceIdUtil
import com.google.gson.Gson
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import java.lang.reflect.Method


/**
 * @ClassName   LogAspect
 * @Description Log切面
 * @Author      pei.zhang
 * @Date        2018/10/18
 * @Version     1.3
 */
@Aspect
@Component
class LogAspect {
    private var logger : Logger = LoggerFactory.getLogger(LogAspect::class.java)
    private val gson : Gson = Gson()

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
        logger.info(methodResponseLogFormat(getMethod(joinPoint), response))
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

    // 获取方法
    private fun getMethod(joinPoint: JoinPoint) : Method {
        // 获取连接点的方法签名对象
        val signature = joinPoint.signature as? MethodSignature
                ?: throw Exception("获取被执行对象签名!")
        val target = joinPoint.target
        // 获取到当前执行的方法
        val method = target.javaClass.getMethod(signature.name, *signature.parameterTypes)
        return method
    }

    // 业务ID是否需要清除
    private fun isNeedDelete(joinPoint: JoinPoint): Boolean {
        // 获取方法信息
        var method = this.getMethod(joinPoint)
        // 获取方法的注解
        val annotation = method.getAnnotation(LogPrint::class.java!!)

        return LogTypeEnum.ENTRANCE == annotation.methodType
    }

    // 获取参数内容
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

        return methodParamsLogFormat(method.name, annotation, args)
    }

    // 线程中清除业务ID
    fun deleteThreadKey() {
        TraceIdUtil.clearTraceId()
    }

    // 方法开始打印日志信息
    private fun methodParamsLogFormat(methodName : String, annotation : LogPrint, params : Array<Any?>?) : String {
        val sb = StringBuilder()
        sb.append("开始:").append("-方法名").append("[").append(methodName).append("]")
                .append("-方法描述").append("[").append(annotation.methodDesc).append("]")
        if (ShowParamsWayEnum.ALL == annotation.showParamsWay || ShowParamsWayEnum.INPUT == annotation.showParamsWay) {
            sb.append("-入参内容")
            params?.forEach { param ->
                sb.append("[").append(gson.toJson(param)).append("]")
            }
        }

        return sb.toString()
    }

    // 方法结束打印日志信息
    private fun methodResponseLogFormat(method : Method, response : Any?) : String {
        val sb = StringBuilder()
        sb.append("结束:")
                .append("-方法名").append("[").append(method.name).append("]")
        val annotation = method.getAnnotation(LogPrint::class.java!!)
        if (ShowParamsWayEnum.ALL == annotation.showParamsWay || ShowParamsWayEnum.OUTPUT == annotation.showParamsWay) {
            sb.append("-响应内容").append("[").append(gson.toJson(response)).append("]")
        }
        return sb.toString()
    }
}