package com.vm.ws.controller;

import com.vm.base.util.BaseWSController;
import com.vm.ws.config.AdminReceiverChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@EnableBinding({AdminReceiverChannel.class})
public class AdminOnlineStatusWSController extends BaseWSController {
    private final static Logger logger = LoggerFactory.getLogger(AdminOnlineStatusWSController.class);

    private final static String DESTINATION = "/adminOnlineStatus";

    @StreamListener(AdminReceiverChannel.ADMIN_INPUT)
    public void receive(Message<String> message) {
        String dataStr = message.getPayload();
        logger.info("AdminOnlineStatusWSController process data is : {} ! ", dataStr);
        Map data = gson.fromJson(dataStr, Map.class);
        String accessToken = (String) data.get("accessToken");
        Object response = data.get("response");
        AdminOnlineStatusWSController.sendToUser(accessToken, DESTINATION, response);
    }


}