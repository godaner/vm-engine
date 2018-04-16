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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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

        Object[] args = proceedingJoinPoint.getArgs();

        if (isNullObject(args)) {
            args = new Object[]{};
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String functionName = proceedingJoinPoint.getSignature().getName();

        logger.info("=====>>>> Request [ info ] is : [ {} # {} ] [ {} # {} ] ! ", functionName, obj2SimpleJSONString(args), url, httpMethod);
//        logger.info("=====>>>> Request info is : {} {}#{} ! ", functionName,url, httpMethod);
        Object result = proceedingJoinPoint.proceed();
        if (isNullObject(result)) {
            result = new Object();
        }
        logger.info("<<<<===== Response [ string ] is : {} !", obj2SimpleJSONString(result));

        return result;
    }


}