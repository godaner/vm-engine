package com.vm.ws.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by ZhangKe on 2018/4/27.
 */
public interface UserOnlineStatusSink {
    String INPUT = "userOnlineStatusInput";

    @Output(INPUT)
    SubscribableChannel input();
}
