package com.vm.auth.user.aop;

import com.vm.auth.user.cache.UserSessionCacheManager;
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
@Order(5)
public class RequiredUserLoginAop extends CommonUtil {

    private final Logger logger = LoggerFactory.getLogger(RequiredUserLoginAop.class);


    @Pointcut("execution(* com.vm..*.controller..*.*(..))")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression() && @annotation(requiredLogin)")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint, RequiredUserLogin requiredLogin) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);

        Long userId = (Long) UserSessionCacheManager.getOnlineUserId(token);
        if (userId == null) {
            throw new VmCommonException(VmCommonException.ErrorCode.USER_IS_OFFLINE.getCode(),
                    VmCommonException.ErrorCode.USER_IS_OFFLINE.getMsg());
        }

        /**
         * 接下来会执行{@link OnlineUserMethodArgumentResolver}
         */

        //执行方法
        return joinPoint.proceed();


    }


}
