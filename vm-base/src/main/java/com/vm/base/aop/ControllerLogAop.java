package com.vm.base.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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

    private String obj2JSONString(Object obj) {
        PropertyFilter profilter = new PropertyFilter() {

            @Override
            public boolean apply(Object object, String name, Object value) {
                if (object instanceof MultipartFile || object instanceof File || object instanceof Byte[] || object instanceof byte[]) {
                    //false表示last字段将被排除在外
                    return false;
                }
                return true;
            }

        };
        SerializeWriter sw = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(sw);
        serializer.getPropertyFilters().add(profilter);
        serializer.write(obj);
        return sw.toString();
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

        logger.info("=====>>>> Request info is : {}#{} {}#{} ! ", url, httpMethod, functionName, obj2JSONString(Lists.newArrayList(args)));
        Object result = proceedingJoinPoint.proceed();
        if (isNullObject(result)) {
            result = new Object();
        }
        logger.info("<<<<===== Response string is : {} !", obj2JSONString(Lists.newArrayList(result)));

        return result;
    }


}