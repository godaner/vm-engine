package com.vm.controllerhelper.aop;

import com.vm.base.service.exception.VmRuntimeException;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
@Order(1)
public class ControllerExceptionHandlerAop extends CommonUtil {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlerAop.class);

    @Pointcut("execution(* com.vm..*controller..*.*(..))")
    public void declareJoinPointExpression() {
    }


    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Exception {
        Response response = new Response();
        Object data = null;

        try {

            //执行方法
            data = joinPoint.proceed();//调用执行目标方法,先執行aop在執行了responsebody

            if (data == null) {//无参数
                return null;
            }


            //如果返回值为Map或者Response的实例，代表采用ajax方式
            if (data instanceof Map) {
                response.setData((Map<Object, Object>) data);
            } else if (data instanceof Response) {
                response = (Response) data;
            } else if (data instanceof String) {//页面转发
                return data;
            }
        } catch (VmRuntimeException e) {//提倡使用
            logger.error(e.getMessage());
            e.printStackTrace();
            response.setCode(e.getErrorCode());
            response.setMsg(e.getErrorMsg());
        } catch (RuntimeException e) {//以下不提倡使用
            logger.error(e.getMessage());
            e.printStackTrace();
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        } catch (Throwable e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        }
        return response;

    }


}
