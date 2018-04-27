package com.vm.admin.ws.controller;

import com.vm.base.util.BaseWSController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = "fanout.adminOnlineStatusWS")
public class AdminOnlineStatusWSController extends BaseWSController {

    protected final static Logger logger = LoggerFactory.getLogger(AdminOnlineStatusWSController.class);

    private final static String DESTINATION = "/adminOnlineStatus";

    @RabbitHandler
    public void process(String dataStr) {
        logger.debug("AdminOnlineStatusWSController process data is : {} ! ", dataStr);
        Map data = gson.fromJson(dataStr, Map.class);
        String accessToken = (String) data.get("accessToken");
        Object response = data.get("response");
        AdminOnlineStatusWSController.sendToUser(accessToken, DESTINATION, response);
    }

}