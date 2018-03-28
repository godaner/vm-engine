package com.vm.base.aop;

import com.vm.base.service.exception.VmRuntimeException;
import com.vm.base.util.AuthCacheManager;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ZhangKe on 2018/3/28.
 */
@Component
@Aspect
@Order(3)
public class AuthValidateAop extends CommonUtil {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAop.class);

    @Pointcut("execution(* com.vm..*controller..*.*(..))")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()&&@annotation(requiredAuth)")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint, RequiredAuth requiredAuth) throws Throwable {

        List<String> requiredAuthCodes = Lists.newArrayList(requiredAuth.auths());


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);
        List<String> haveAuthCodes = AuthCacheManager.getAuthCodes(token);

        if (isNullObject(haveAuthCodes)) {
            haveAuthCodes = Lists.newArrayList();
        }

        boolean haveAuth = true;
        for (String requiredAuthCode : requiredAuthCodes) {

            if (!haveAuthCodes.contains(requiredAuthCode)) {
                haveAuth = false;
                break;
            }
        }

        if (!haveAuth) {
            throw new VmRuntimeException("AuthValidateAop admin accessToken : " + token + " is have not auth ! required auth codes is : " + requiredAuthCodes + " , admin have auth codes is : " + haveAuthCodes,
                    -555, "您没有权限进行此操作");
        }

        return joinPoint.proceed();

    }

}
