package com.vm.ws.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserReceiverChannel {

    String USER_INPUT = "userInput";

    @Input(UserReceiverChannel.USER_INPUT)
    SubscribableChannel userInput();
}