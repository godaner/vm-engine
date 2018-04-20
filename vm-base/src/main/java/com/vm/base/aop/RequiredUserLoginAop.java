package com.vm.base.aop;

import com.vm.base.service.exception.VmCommonException;
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
 * 当方法含有{@link RequiredUserLogin}注解，那么去除其token 验证是否登录
 */
@Component
@Aspect
@Order(2)
public class RequiredUserLoginAop extends CommonUtil {

    private final Logger logger = LoggerFactory.getLogger(RequiredUserLoginAop.class);


    @Pointcut("execution(* com.vm..*.controller..*.*(..))")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression() && @annotation(requiredLogin)")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint, RequiredUserLogin requiredLogin) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object onlineUserId = request.getSession().getAttribute(OnlineConstants.KEY_OF_SESSION_USER_ID);


        if (onlineUserId == null) {
            throw new VmCommonException("RequiredAdminLoginAop user is offline !",
                    VmCommonException.ErrorCode.USER_IS_OFFLINE.getCode(),
                    VmCommonException.ErrorCode.USER_IS_OFFLINE.getMsg());
        }

        /**
         * 接下来会执行{@link OnlineUserMethodArgumentResolver}
         */

        //执行方法
        return joinPoint.proceed();


    }


}
