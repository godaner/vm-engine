package com.vm.user.ws.controller;

import com.vm.base.util.BaseWSController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = "fanout.userOnlineStatusWS")
public class UserOnlineStatusWSController extends BaseWSController {

    protected final static Logger logger = LoggerFactory.getLogger(UserOnlineStatusWSController.class);

    private final static String DESTINATION = "/userOnlineStatus";

    @RabbitHandler
    public void process(String dataStr) {
        logger.info("UserOnlineStatusWSController process data is : {} ! ", dataStr);
        Map data = gson.fromJson(dataStr, Map.class);
        String accessToken = (String) data.get("accessToken");
        Object response = data.get("response");
        UserOnlineStatusWSController.sendToUser(accessToken, DESTINATION, response);
    }

}