package com.vm.user.controller;

import com.vm.base.util.ServiceController;
import com.vm.user.service.dto.VmUsersLoginAreaCountDto;
import com.vm.user.service.dto.VmUsersSexCountDto;
import com.vm.user.service.inf.VmUsersCountService;
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
        List<VmUsersSexCountDto> usersCountDtos = service.getUserSexCount();
        return response.putData("list", usersCountDtos);
    }
    /**
     * 统计用户性别<br/>
     *
     * @return
     */
    @RequestMapping(value = "/area", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserAreaCount( ) throws Exception {
        List<VmUsersLoginAreaCountDto> vmUsersLoginAreaCountDtos = service.getUserAreaCount();
        return response.putData("list", vmUsersLoginAreaCountDtos);
    }

}

