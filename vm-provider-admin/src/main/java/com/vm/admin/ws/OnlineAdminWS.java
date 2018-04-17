package com.vm.admin.ws;

import com.google.common.collect.Maps;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ZhangKe on 2018/04/16.
 */
@ServerEndpoint(value = "/admin/online/{accessToken}")
@Component
public class OnlineAdminWS extends CommonUtil {
    private final static Logger logger = LoggerFactory.getLogger(OnlineAdminWS.class);
    /**
     * 在线人数
     */
    public static volatile int onlineNumber = 0;

    /**
     * 所有的对象
     */
    public static Map<String, OnlineAdminWS> webSockets = Maps.newConcurrentMap();

    /**
     * 会话
     */
    private Session session;
    /**
     * accessToken
     */
    private String accessToken;

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("accessToken") String accessToken, Session session) {
        if (isNullObject(accessToken)) {
            return;
        }
        //old ws
        OnlineAdminWS onlineUserWS = webSockets.get(accessToken);
        if (onlineUserWS != null) {
            Response response = new Response();
            response.setMsg("您的账户正在其他地方登录");
            onlineUserWS.sendMessage(response.toJSON());
        }
        // new ws
        this.session = session;

        this.accessToken = accessToken;

        onlineNumber++;

        webSockets.put(accessToken, this);

        logger.info("OnlineAdminWS in session accessToken is : {} , onlineNumber is : {} ! ", accessToken, onlineNumber);
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        webSockets.remove(accessToken);
        logger.info("OnlineAdminWS out session accessToken is : {} , onlineNumber is : {} ! ", accessToken, onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("OnlineAdminWS session receive msg is : {} , accessToken is : {} , onlineNumber is : {} ! ", message, accessToken, onlineNumber);
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  