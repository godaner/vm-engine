package com.vm.frontend.resolve;

import com.vm.frontend.service.dto.VmUsersDto;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 增加方法注入，将含有 @OnlineUser 注解的方法参数注入当前登录用户
 */
public class OnlineUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(VmUsersDto.class)
                && parameter.hasParameterAnnotation(OnlineUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        VmUsersDto user = (VmUsersDto) webRequest.getAttribute(OnlineConstants.KEY_OF_ONLINE_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(OnlineConstants.KEY_OF_ONLINE_USER);
    }

}


