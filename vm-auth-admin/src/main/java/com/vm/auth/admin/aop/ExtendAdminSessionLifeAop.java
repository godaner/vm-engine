package com.vm.auth.admin.aop;


import com.vm.auth.admin.cache.AdminSessionCacheManager;
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
import java.util.Map;


/**
 * 延长session生命时间
 */
@Component
@Aspect
@Order(2)
public class ExtendAdminSessionLifeAop extends CommonUtil {

    private final Logger logger = LoggerFactory.getLogger(ExtendAdminSessionLifeAop.class);

    @Pointcut("execution(* com.vm..controller.*.*(..))&&!@annotation(IgnoreExtendAdminSessionLife)")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object data = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);

        Map res = null;

        //延长其生命周期
        res = AdminSessionCacheManager.extendSessionLife(token);
        if (!isNullObject(res)) {
            logger.info("ExtendSessionLifeAop extend admin session life ! admin id is : " + res.get("userId") + " , token is : " + res.get("token"));
        }

        //execute
        data = joinPoint.proceed();

        return data;

    }



}
