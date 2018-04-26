package com.vm.controllerhelper.aop;

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
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlerAop.class);

    @Pointcut("execution(* com.vm..*controller..*.*(..))")
    public void logPointcut() {
    }


    @Around("logPointcut()")
    public Object doSurround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String randomStr = CommonUtil.generateShortUuid();

        Object[] args = proceedingJoinPoint.getArgs();

        String functionName = proceedingJoinPoint.getSignature().getName();

        logger.info("=====>>>> [ {} ] Request [ {} ] , [ args ] is : {} ! ", randomStr, functionName, CommonUtil.jsonLog(args));

        Object result = proceedingJoinPoint.proceed();

        logger.info("<<<<===== [ {} ] Response [ {} ] , [ res ] is : {} ! ", randomStr, CommonUtil.jsonLog(result));

        return result;
    }


}