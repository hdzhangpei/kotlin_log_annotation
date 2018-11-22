package com.annotation.log.logutil.aspect

import com.annotation.log.logutil.annotation.LogPrint
import com.annotation.log.logutil.domain.LogTypeEnum
import com.annotation.log.logutil.util.LogKey.clearThreadKey
import com.annotation.log.logutil.util.Logger
import com.annotation.log.logutil.util.LoggerFactory
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
 * @Version     1.0
 */
@Aspect  // 切面标识
@Component  // 交给spring容器管理
class LogAspect {
    private var logger : Logger = LoggerFactory.getLogger(LogAspect::class.java)
//    private val gson : Gson = Gson()
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
        logger.info(methodResponseLogFormat(getMethod(joinPoint).name, response))
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

        return methodParamsLogFormat(method.name, annotation.desc, args)
    }

    fun deleteThreadKey() {
        clearThreadKey()
    }

    private fun methodParamsLogFormat(methodName : String, methodDesc : String, params : Array<Any?>?) : String {
        val sb = StringBuilder()
        sb.append("开始:").append("-方法名").append("[").append(methodName).append("]")
                .append("-方法描述").append("[").append(methodDesc).append("]")
                //.append("-入参内容")

//        params?.forEach { param ->
//            sb.append("[").append(gson.toJson(param)).append("]")
//        }

        return sb.toString()
    }

    private fun methodResponseLogFormat(methodName : String, response : Any?) : String {
        val sb = StringBuilder()
        sb.append("结束:")
                .append("-方法名").append("[").append(methodName).append("]")
                //.append("-响应内容").append("[").append(gson.toJson(response)).append("]")

        return sb.toString()
    }
}