package com.vm.frontend.controller;

import com.vm.base.utils.ServiceController;
import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.dao.validator.group.VmUsersGroups;
import com.vm.frontend.service.inf.VmUsersService;
import com.vm.frontend.websocket.OnlineUsersWebSocket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/01/03.
 */
@Controller
@RequestMapping("/user/ws/ctrl")
@Scope("prototype")
public class VmUsersWebSocketController extends ServiceController<VmUsersService> {
    @RequestMapping(value = "/login/{userId}", method = RequestMethod.PUT)
    public void userLogin(@PathVariable("userId")Long userId) throws Exception {
        OnlineUsersWebSocket.userLogout(userId,OnlineUsersWebSocket.Result.LOGIN_OTHER_AREA.getCode());
        OnlineUsersWebSocket.userLogin(userId);
    }
    @RequestMapping(value = "/logout/{userId}", method = RequestMethod.PUT)
    public void userLogout(@PathVariable("userId")Long userId) throws Exception {
        OnlineUsersWebSocket.userLogout(userId,OnlineUsersWebSocket.Result.LOGIN_SUCCESS.getCode());
    }
}

