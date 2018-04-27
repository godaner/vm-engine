package com.vm.admin.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(AdminSendChannel.class)
public class SendServerConfig {

}