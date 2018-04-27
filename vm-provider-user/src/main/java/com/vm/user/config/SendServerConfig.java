package com.vm.user.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(UserSendChannel.class)
public class SendServerConfig {

}