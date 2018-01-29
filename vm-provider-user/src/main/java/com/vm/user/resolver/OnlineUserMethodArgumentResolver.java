package com.vm.user.resolver;

import com.vm.base.util.CommonUtil;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.inf.VmUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 增加方法注入，将含有 {@link @OnlineUser} 注解的方法参数注入当前登录用户的实例
 */
@Component
public class OnlineUserMethodArgumentResolver extends CommonUtil implements HandlerMethodArgumentResolver {

    @Autowired
    private VmUsersService vmUsersService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(VmUsersDto.class)
                && parameter.hasParameterAnnotation(OnlineUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String token = webRequest.getHeader(OnlineConstants.KEY_OF_ACCESS_TOKEN);


        VmUsersDto vmUsersDto = vmUsersService.getOnlineUser(token);


        if (vmUsersDto != null) {
            //set token
            vmUsersDto.setToken(token);
            return vmUsersDto;
        }
        return vmUsersDto;
//        throw new MissingServletRequestPartException(OnlineConstants.KEY_OF_ONLINE_USER);
    }


}


