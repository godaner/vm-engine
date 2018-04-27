package com.vm.ws.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AdminReceiverChannel {

    String ADMIN_INPUT = "adminInput";

    @Input(AdminReceiverChannel.ADMIN_INPUT)
    SubscribableChannel adminInput();
}