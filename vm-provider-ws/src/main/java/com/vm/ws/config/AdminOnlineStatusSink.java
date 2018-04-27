package com.vm.ws.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by ZhangKe on 2018/4/27.
 */
public interface AdminOnlineStatusSink {
    String INPUT = "adminOnlineStatusInput";

    @Output(INPUT)
    SubscribableChannel input();
}
