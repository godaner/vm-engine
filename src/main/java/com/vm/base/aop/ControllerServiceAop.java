package com.vm.base.aop;

import com.vm.base.bo.Response;
import com.vm.base.utils.LoggerWrapper;
import com.vm.service.exception.VMRuntimeException;
import com.vm.service.exception.ValidateRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer(joinPoint.getSignature().toString() +" ==>PARAMS: "+ Arrays.toString(joinPoint.getArgs()));

        logger.info(sb.toString());

        Response response = null;
        Object data = null;
        try {
            data = joinPoint.proceed();//调用执行目标方法,先執行aop在執行了responsebody

            if(data == null){//无参数
                return null;
            }
            response = new Response();

            //如果返回值为Map或者Response的实例，代表采用ajax方式
            if(data instanceof Map){
                response.setData((Map<Object, Object>) data);
            }else if(data instanceof Response){
                response = (Response)data;
            }else{
                return data;
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
