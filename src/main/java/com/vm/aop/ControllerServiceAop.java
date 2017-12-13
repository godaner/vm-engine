package com.vm.aop;

import com.alibaba.fastjson.JSON;
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
    @Pointcut("execution(* com.vm..controller..*.*(..))")
    public void declareJoinPointExpression() {


    }

    private Logger logger = LoggerFactory.getLogger(ControllerServiceAop.class);

    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) {
        StringBuffer method = new StringBuffer(joinPoint.getSignature().toString());

        logger.info("VISIT ==> method ==> {} ==> params ==> {}",method.toString(),Arrays.toString(joinPoint.getArgs()));

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
            }else{//页面转发
                return data;
            }
        } catch (VmRuntimeException e) {//提供详细错误信息输出到前台
            e.printStackTrace();
            logger.error("ERROR ==> {} ==> {}",method.toString(),e.toString());
            response.setCode(e.getErrorCode().intValue());
            response.setMsg(e.getMessage());
        } catch (RuntimeException e) {//只输出failed信息，不提供详细错误信息
            e.printStackTrace();
            logger.error("ERROR ==> {} ==> {}",method.toString(),e.toString());
            response.setCode(VmRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VmRuntimeException.ErrorCode.UNKNOWN.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR ==> {} ==> {}",method.toString(),e.toString());
            response.setCode(VmRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VmRuntimeException.ErrorCode.UNKNOWN.getMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("ERROR ==> {} ==> {}",method.toString(),e.toString());
            response.setCode(VmRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VmRuntimeException.ErrorCode.UNKNOWN.getMsg());
        }
        logger.info("Response ==> {}", response);
        return response;

    }

}
