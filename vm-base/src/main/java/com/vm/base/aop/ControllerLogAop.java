package com.vm.base.aop;

import com.alibaba.fastjson.JSONObject;
import com.vm.base.util.CommonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by sigh on 2015/6/25.
 */
@Component
@Aspect
@Order(0)
public class ControllerLogAop extends CommonUtil {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlerAop.class);

    @Pointcut("execution(* com.vm..*controller..*.*(..))")
    public void logPointcut() {
    }

    @Around("logPointcut()")
    public Object doSurround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object[] args = proceedingJoinPoint.getArgs();
        if (isNullObject(args)) {
            args = new Object[]{};
        }
        String name = proceedingJoinPoint.getSignature().getName();
        logger.info("======>> In class is : {}, function name is : {} !", proceedingJoinPoint.getTarget().getClass().getName(), name);
        logger.info("Request args is : {} !", JSONObject.toJSON(args).toString());


        Object result = proceedingJoinPoint.proceed();


        if (isNullObject(result)) {
            result = new Object();
        }
        logger.info("Response is : {} !", JSONObject.toJSON(result).toString());
        logger.info("<<======= Out execute time: {} !", System.currentTimeMillis() - startTime);

        return result;
    }

}