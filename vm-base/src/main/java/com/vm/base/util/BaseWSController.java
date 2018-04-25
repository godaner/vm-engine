package com.vm.base.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/4/25.
 */
public class BaseWSController extends CommonUtil {
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;
    public static SimpMessageSendingOperations simpMessageSendingOperationsCache;

    @PostConstruct
    public void init() {
        simpMessageSendingOperationsCache = simpMessageSendingOperations;
    }

    public final static void sendToUser(String user, String destination, Object payload) {
        simpMessageSendingOperationsCache.convertAndSendToUser(user, destination, payload);
    }

    public final static void send(String destination, Object payload) {
        simpMessageSendingOperationsCache.convertAndSend(destination, payload);
    }
}
