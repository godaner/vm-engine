package com.vm.frontend.listener;

import com.vm.base.utils.CommonUtil;
import com.vm.dao.po.VmUsers;
import com.vm.frontend.controller.VmUsersController;
import com.vm.frontend.service.dto.VmUsersDto;
import com.vm.frontend.websocket.OnlineUsersWebSocket;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

/**
 * Created by ZhangKe on 2017/12/29.
 */
@WebListener
public class SessionListener extends CommonUtil implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {

        logger.info("SessionListener sessionCreated success!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        VmUsersDto vmUsersDto = (VmUsersDto) se.getSession().getAttribute(VmUsersController.KEY_OF_ONLINE_USER);

        if (isNullObject(vmUsersDto)) {
            return;
        }
        try {
            OnlineUsersWebSocket.userLogout(vmUsersDto.getId(), OnlineUsersWebSocket.Result.SESSION_TIMEOUT.getCode());
            logger.info("SessionListener userLogout is success! user is : {}", vmUsersDto);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("SessionListener userLogout is fail! user is : {}", vmUsersDto);
        }
        logger.info("SessionListener sessionDestroyed success!");

    }
}
