package com.vm.base.aop;

import com.vm.base.bo.Response;
import com.vm.base.utils.LoggerWrapper;
import com.vm.controller.UsersController;
import com.vm.service.exception.VMRuntimeException;
import com.vm.service.exception.ValidateRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
@Aspect
public class ControllerServiceAop {
    @Pointcut("execution(* com.vm..controller..*.*(..))")
    public void declareJoinPointExpression() {


    }

    private LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(ControllerServiceAop.class);

    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws ClassNotFoundException, NotFoundException {
        StringBuffer sb = new StringBuffer(joinPoint.getSignature().toString() +" ==>PARAMS: "+ Arrays.toString(joinPoint.getArgs()));

        logger.info(sb.toString());

        Response response = new Response();
        Object data = null;
        try {
            data = joinPoint.proceed();//调用执行目标方法,先執行aop在執行了responsebody
            if(data !=null){
                response.setData((Map<Object, Object>) data);
            }
        } catch (ValidateRuntimeException e) {
            logger.info(sb.toString()+" ==>ERROR: "+e);
            response.setCode(e.getErrorCode().intValue());
            response.setMsg(e.getMessage());
            response.setMsg(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.info(sb.toString()+" ==>ERROR: "+e);
            response.setCode(VMRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VMRuntimeException.ErrorCode.UNKNOWN.getMsg());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info(sb.toString()+" ,error:"+throwable.toString());
            response.setCode(VMRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VMRuntimeException.ErrorCode.UNKNOWN.getMsg());
        }

        return response;

    }

}
