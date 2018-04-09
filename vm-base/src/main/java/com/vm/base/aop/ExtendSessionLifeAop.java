package com.vm.base.aop;


import com.vm.base.util.AdminSessionCacheManager;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.UserSessionCacheManager;
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

//import com.vm.user.resolver.OnlineConstants;
//import com.vm.user.util.SessionManager;

/**
 * 延长session生命时间
 */
@Component
@Aspect
@Order(3)
public class ExtendSessionLifeAop extends CommonUtil {

    private final Logger logger = LoggerFactory.getLogger(ExtendSessionLifeAop.class);


    @Pointcut("execution(* com.vm..*.controller..*.*(..))&&!@annotation(com.vm.base.aop.IgnoreExtendSessionLife)")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object data = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);

        //延长其生命周期
        AdminSessionCacheManager.extendSessionLife(token);

        UserSessionCacheManager.extendSessionLife(token);
        //execute
        data = joinPoint.proceed();

        return data;

    }


//    private HttpServletRequest getHttpServletRequest() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = attributes.getRequest();
//        return httpServletRequest;
//    }

}
