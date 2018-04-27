package com.vm.mq.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by ZhangKe on 2018/4/27.
 */
public interface UserOnlineStatusSource {
    String OUTPUT = "userOnlineStatusOutput";

    @Output(OUTPUT)
    MessageChannel output();
}
