package com.vm.admin.resolver;

import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.base.aop.OnlineConstants;
import com.vm.base.util.CommonUtil;
import com.vm.dao.util.BasePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 增加方法注入，将含有 {@link @OnlineAdmin} 注解的方法参数注入当前登录用户的实例
 */
@Component
@Order(4)
public class OnlineAdminMethodArgumentResolver extends CommonUtil implements HandlerMethodArgumentResolver {

    @Autowired
    private VmAdminsService vmAdminsService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(VmAdminsDto.class)
                && parameter.hasParameterAnnotation(OnlineAdmin.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Object onlineAdminId = webRequest.getAttribute(OnlineConstants.KEY_OF_SESSION_ADMIN_ID,NativeWebRequest.SCOPE_SESSION);


        VmAdminsDto vmAdminsDto = null;
        try {
            vmAdminsDto = vmAdminsService.getOnlineAdminBasicInfo((Long) onlineAdminId);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return vmAdminsDto;
    }


}


