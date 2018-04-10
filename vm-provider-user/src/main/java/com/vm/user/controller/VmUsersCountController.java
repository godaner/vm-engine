package com.vm.user.controller;

import com.vm.base.aop.IgnoreExtendSessionLife;
import com.vm.base.aop.RequiredAdminLogin;
import com.vm.base.aop.RequiredAuth;
import com.vm.base.aop.RequiredUserLogin;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.resolver.OnlineUser;
import com.vm.user.service.dto.VmUsersCountDto;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.inf.VmUsersCountService;
import com.vm.user.service.inf.VmUsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/user/count")
@Scope("prototype")
public class VmUsersCountController extends ServiceController<VmUsersCountService> {

    /*********************************统计****************************/

    /**
     * 统计用户性别<br/>
     *
     * @return
     */
    @RequestMapping(value = "/sex", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserSexCount( ) throws Exception {
        List<VmUsersCountDto> usersCountDtos = service.getUserSexCount();
        return response.putData("list", usersCountDtos);
    }

}

