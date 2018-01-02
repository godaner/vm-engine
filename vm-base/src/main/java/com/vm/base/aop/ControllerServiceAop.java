package com.vm.base.aop;

import com.alibaba.fastjson.JSON;
import com.vm.base.exception.VmRuntimeException;
import com.vm.base.utils.Response;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class ControllerServiceAop {

    private final Logger logger = LoggerFactory.getLogger(ControllerServiceAop.class);

    @Pointcut("execution(* com.vm.*.controller..*.*(..))")
    public void declareJoinPointExpression() {
    }

    @Around("declareJoinPointExpression()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Exception {
        Response response = new Response();
        Object data = null;
        String method = "";
        String methodArgsNameAndValue = getMethodArgsNameAndValue(joinPoint).toString();
        String requestUrl = getRequestUrl();
        try {
            logger.info("Request ==> requestUrl is : {} , requestMethod is :[{} # {}]", requestUrl, getMethod(joinPoint), methodArgsNameAndValue);

            //获取验证结果
            List<BindingResult> bindingResults = getBindingResult(joinPoint.getArgs());
            //抛出验证结果
            validate(bindingResults);

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
            } else {//页面转发
                return data;
            }
        } catch (VmRuntimeException e) {//提供详细错误信息输出到前台
            e.printStackTrace();
            logger.error("ERROR ==> [{} # {}] ==> {}", method.toString(), methodArgsNameAndValue, e.toString());
            response.setCode(e.getErrorCode());
            response.setMsg(e.getMessage());
        } catch (RuntimeException e) {//只输出failed信息，不提供详细错误信息
            e.printStackTrace();
            logger.error("ERROR ==> [{} # {}] ==> {}", method.toString(), methodArgsNameAndValue, e.toString());
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR ==> [{} # {}] ==> {}", method.toString(), methodArgsNameAndValue, e.toString());
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("ERROR ==> [{} # {}] ==> {}", method.toString(), methodArgsNameAndValue, e.toString());
            response.setCode(Response.ResponseCode.FAILURE.getCode());
            response.setMsg(Response.ResponseCode.FAILURE.getMsg());
        }
        if (data instanceof Response) {
            logger.info("Response String ==> {}", JSON.toJSONString(response));
        }
        return response;

    }
    /**********************************辅助方法*****************************************/


    /**
     * 通过反射机制 获取被切参数名以及参数值
     *
     * @param cls
     * @param clazzName
     * @param methodName
     * @param args
     * @return
     * @throws NotFoundException
     */
    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();

        ClassPool pool = ClassPool.getDefault();
        //ClassClassPath classPath = new ClassClassPath(this.getClass());
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        // String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            map.put(attr.variableName(i + pos), args[i]);//paramNames即参数名
        }
        return map;
    }

    private Map<String, Object> getMethodArgsNameAndValue(ProceedingJoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        String methodName = joinPoint.getSignature().getName(); //获取方法名称
        Object[] args = joinPoint.getArgs();//参数
        Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, args);//获取被切参数名称及参数值
        //获取参数名称和值
        return nameAndArgs;
    }

    private String getRequestUrl() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getRequestURL().toString();
    }

    private String getMethod(ProceedingJoinPoint joinPoint) {

        StringBuffer method = new StringBuffer(joinPoint.getSignature().toString());
        return method.toString();
    }


    /**
     * 通过切面参数获取其中的BindingResult
     *
     * @param args
     * @return
     */
    private List<BindingResult> getBindingResult(Object[] args) {
        List<BindingResult> bindingResults = Lists.newArrayList();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                bindingResults.add((BindingResult) arg);
            }
        }
        return bindingResults;
    }

    /**
     * Title:getErrors
     * <p>
     * Description:获取hibernate-validator的错误信息;
     * <p>
     *
     * @param result
     * @return
     * @author Kor_Zhang
     * @date 2017年9月22日 下午8:15:21
     * @version 1.0
     */
    private static Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            System.out.println("error.getField():" + error.getField());
            System.out.println("error.getDefaultMessage():"
                    + error.getDefaultMessage());

            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }

    /**
     * Title:validate
     * <p>
     * Description:如果hibernate-validator验证有错误信息,那么抛出携带错误信息的异常;
     * <p>
     *
     * @param bindingResults
     * @return
     * @throws Exception
     * @author Kor_Zhang
     * @date 2017年9月22日 下午8:15:21
     * @version 1.0
     */
    private static void validate(List<BindingResult> bindingResults) throws Exception {
        if (bindingResults == null) {
            return;
        }
        for (BindingResult bindingResult : bindingResults) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list) {
                throw new VmRuntimeException(error.getDefaultMessage());
            }
        }

    }

}
