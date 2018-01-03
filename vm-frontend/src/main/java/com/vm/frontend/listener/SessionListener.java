package com.vm.frontend.listener;

import com.vm.base.utils.CommonUtil;
import com.vm.dao.po.VmUsers;
import com.vm.frontend.controller.VmUsersController;
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
        VmUsers vmUsers = (VmUsers) se.getSession().getAttribute(VmUsersController.KEY_OF_ONLINE_USER);

        if (isNullObject(vmUsers)) {
            return;
        }
        try {
            OnlineUsersWebSocket.userLogout(vmUsers.getId(), OnlineUsersWebSocket.Result.SESSION_TIMEOUT.getCode());
            logger.info("SessionListener userLogout is success! user is : {}", vmUsers);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("SessionListener userLogout is fail! user is : {}", vmUsers);
        }
        logger.info("SessionListener sessionDestroyed success!");

    }
}
