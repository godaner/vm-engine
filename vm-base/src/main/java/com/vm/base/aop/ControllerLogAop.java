package com.vm.base.aop;

import com.alibaba.fastjson.JSONObject;
import com.vm.base.util.CommonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        List nArgs = filterObjs(Lists.newArrayList(args));
        String name = proceedingJoinPoint.getSignature().getName();
        logger.info("======>> In class is : {}, function name is : {} !", proceedingJoinPoint.getTarget().getClass().getName(), name);
        logger.info("Request args is : {} !", JSONObject.toJSON(nArgs).toString());


        Object result = proceedingJoinPoint.proceed();


        if (isNullObject(result)) {
            result = new Object();
        }
        logger.info("Response is : {} !", JSONObject.toJSON(result).toString());
        logger.info("<<======= Out execute time: {} !", System.currentTimeMillis() - startTime);

        return result;
    }

    private List filterObjs(List<Object> objects) {
        if(isEmptyList(objects)){
            return Lists.newArrayList();

        }
        List ret = objects.stream().parallel().filter(o -> {
            return !isByteArray(o);
        }).map(o -> {
            return o;
        }).collect(toList());
        if (isEmptyList(ret)) {
        }
        return ret;
    }

    public boolean isByteArray(Object o) {

        return (o instanceof Byte[] || o instanceof byte[]);
    }
}