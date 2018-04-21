package com.vm.base.aop;

import com.vm.base.util.CommonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by sigh on 2015/6/25.
 */
@Component
@Aspect
@Order(0)
public class ControllerLogAop extends CommonUtil {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlerAop.class);
    private final static Random random = new Random(99999);

    @Pointcut("execution(* com.vm..*controller..*.*(..))")
    public void logPointcut() {
    }


    @Around("logPointcut()")
    public Object doSurround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Integer no = random.nextInt();

        Object[] args = proceedingJoinPoint.getArgs();

        String functionName = proceedingJoinPoint.getSignature().getName();

        logger.info("=====>>>> [ {} ] Request [ {} ] , [ args ] is : {} ! ", no, functionName, jsonLog(args));

        Object result = proceedingJoinPoint.proceed();

        logger.info("<<<<===== [ {} ] Response [ {} ] , [ res ] is : {} ! ", no, jsonLog(result));

        return result;
    }


}