package com.vm.ws.controller;

import com.vm.base.util.BaseWSController;
import com.vm.ws.config.AdminReceiverChannel;
import com.vm.ws.config.UserReceiverChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.util.Map;


@EnableBinding(UserReceiverChannel.class)
public class UserOnlineStatusWSController extends BaseWSController {

    protected final static Logger logger = LoggerFactory.getLogger(UserOnlineStatusWSController.class);

    private final static String DESTINATION = "/userOnlineStatus";


    @StreamListener(UserReceiverChannel.USER_INPUT)
    public void receive(Message<String> message) {
        String dataStr = message.getPayload();
        logger.info("UserOnlineStatusWSController process data is : {} ! ", dataStr);
        Map data = gson.fromJson(dataStr, Map.class);
        String accessToken = (String) data.get("accessToken");
        Object response = data.get("response");
        AdminOnlineStatusWSController.sendToUser(accessToken, DESTINATION, response);
    }


}