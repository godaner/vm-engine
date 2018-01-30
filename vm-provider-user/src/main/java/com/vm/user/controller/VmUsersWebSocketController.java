package com.vm.user.controller;

import com.vm.base.util.ServiceController;
import com.vm.user.service.inf.VmUsersService;
import com.vm.user.websocket.OnlineUsersWebSocket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2017/01/03.
 */
@Controller
@RequestMapping("/user/ws/ctrl")
@Scope("prototype")
public class VmUsersWebSocketController extends ServiceController<VmUsersService> {
    @RequestMapping(value = "/login/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogin(@PathVariable("userId") Long userId) throws Exception {
        OnlineUsersWebSocket.userLogout(userId, OnlineUsersWebSocket.Result.LOGIN_OTHER_AREA.getCode());
        OnlineUsersWebSocket.userLogin(userId);
        return response;
    }

    @RequestMapping(value = "/logout/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogout(@PathVariable("userId") Long userId) throws Exception {
        OnlineUsersWebSocket.userLogout(userId, OnlineUsersWebSocket.Result.LOGIN_SUCCESS.getCode());
        return response;
    }
}

