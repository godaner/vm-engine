package com.vm.aop;

import com.vm.controller.Response;
import com.vm.service.exception.VmRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
    @Pointcut("execution(* com.vm..controller.frontend..*.*(..))")
    public void declareJoinPointExpression() {


    }

    private Logger logger = LoggerFactory.getLogger(ControllerServiceAop.class);

    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer(joinPoint.getSignature().toString() +" ==>PARAMS: "+ Arrays.toString(joinPoint.getArgs()));

        logger.info(sb.toString());

        Response response = new Response();
        Object data = null;
        try {
            data = joinPoint.proceed();//调用执行目标方法,先執行aop在執行了responsebody

            if(data == null){//无参数
                return null;
            }

            //如果返回值为Map或者Response的实例，代表采用ajax方式
            if(data instanceof Map){
                response.setData((Map<Object, Object>) data);
            }else if(data instanceof Response){
                response = (Response)data;
            }else{
                return data;
            }
        } catch (VmRuntimeException e) {
            e.printStackTrace();
            logger.error("{} ==>ERROR: {}",sb.toString(),e.toString());
            response.setCode(e.getErrorCode().intValue());
            response.setMsg(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("{} ==>ERROR: {}",sb.toString(),e.toString());
            response.setCode(VmRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VmRuntimeException.ErrorCode.UNKNOWN.getMsg());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error("{} ==>ERROR: {}",sb.toString(),throwable.toString());
            response.setCode(VmRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VmRuntimeException.ErrorCode.UNKNOWN.getMsg());
        }
        logger.info("Response ==> {}",response.toString());
        return response;

    }

}
