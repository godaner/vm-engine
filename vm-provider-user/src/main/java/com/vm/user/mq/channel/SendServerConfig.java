package com.vm.user.mq.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(UserSendChannel.class)
public class SendServerConfig {

}