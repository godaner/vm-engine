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

import java.util.Map;

@Component
@Aspect
public class ControllerServiceAop {
    @Pointcut("execution(* com.vm..controller..*.*(..))")
    public void declareJoinPointExpression() {


    }

    private LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(ControllerServiceAop.class);

    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info(proceedingJoinPoint.getSignature() + " " + proceedingJoinPoint.getArgs());
        System.out.println();
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringTypeName());
        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        Response response = new Response();
        Object data = null;
        try {
            data = proceedingJoinPoint.proceed();//调用执行目标方法,先執行aop在執行了responsebody
            if(data !=null){
                response.setData((Map<Object, Object>) data);
            }
        } catch (ValidateRuntimeException e) {
//            logger.error("UsersController#insert error name {} ,password {}, ", name, password);
            response.setCode(e.getErrorCode().intValue());
            response.setMsg(e.getMessage());
            response.setMsg(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
//            logger.error("UsersController#insert error name {} ,password {}, ", name, password);
            response.setCode(VMRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
            response.setMsg(VMRuntimeException.ErrorCode.UNKNOWN.getMsg());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return response;



//        logger.info("UsersController#insert name {}, password {}", name, password);
//
//        try {
//            service.add(name,password);
//        } catch (ValidateRuntimeException e) {
//            logger.error("UsersController#insert error name {} ,password {}, ",name,password);
//            response.setCode(e.getErrorCode().intValue());
//            response.setMsg(e.getMessage());
//            response.setMsg(e.getMessage());
//            e.printStackTrace();
//        }catch (Exception e) {
//            logger.error("UsersController#insert error name {} ,password {}, ",name,password);
//            response.setCode(VMRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
//            response.setMsg(VMRuntimeException.ErrorCode.UNKNOWN.getMsg());
//        }
//
//        logger.info("UsersController#insert response {}", response);
//        return response;
    }
}
