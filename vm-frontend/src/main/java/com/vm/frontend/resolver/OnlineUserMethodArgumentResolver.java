package com.vm.frontend.resolver;

import com.vm.base.util.CommonUtil;
import com.vm.frontend.service.dto.VmUsersDto;
import com.vm.frontend.service.inf.VmUsersService;
import com.vm.frontend.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;

/**
 * 增加方法注入，将含有 {@link @OnlineUser} 注解的方法参数注入当前登录用户的实例
 */
@Order(52)
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

        if(null == token){
            return null;
        }
        String userId = (String) SessionManager.getOnlineUserInfo(token);
        if(null == userId){
            return null;
        }

        VmUsersDto vmUsersDto = vmUsersService.getOnlineUser(userId);

        if (vmUsersDto != null) {
            //set token
            vmUsersDto.setToken(token);
            return vmUsersDto;
        }
        throw new MissingServletRequestPartException(OnlineConstants.KEY_OF_ONLINE_USER);
    }


}


