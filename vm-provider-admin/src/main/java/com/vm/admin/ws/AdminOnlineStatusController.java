package com.vm.admin.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;


@Controller
public class AdminOnlineStatusController {
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;
    public static SimpMessageSendingOperations simpMessageSendingOperationsCache;

    @PostConstruct
    public void init() {
        simpMessageSendingOperationsCache = simpMessageSendingOperations;
    }

//    @MessageMapping("/login")
//    @SendTo("/topic/adminOnlineStatus")
//    public void greeting(String accessToken, WebSocketSession webSocketSession) throws Exception {
//        return new Msg("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");


//    }

}