package com.vm.user.aop;


import com.vm.base.util.CommonUtil;
import com.vm.user.resolver.OnlineConstants;
import com.vm.user.util.SessionManager;
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
 * 延长session生命时间
 */
@Component
@Aspect
@Order(3)
public class ExtendSessionLife extends CommonUtil {

    private final Logger logger = LoggerFactory.getLogger(ExtendSessionLife.class);


    @Pointcut("execution(* com.vm..*.controller..*.*(..))&&!@annotation(IgnoreExtendSessionLife)")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Exception {
        Object data = null;
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);

            //延长其生命周期
            SessionManager.extendSessionLife(token);

            //execute
            data = joinPoint.proceed();


        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("ERROR ==>  {}", e.toString());
        }
        return data;

    }


//    private HttpServletRequest getHttpServletRequest() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = attributes.getRequest();
//        return httpServletRequest;
//    }

}
