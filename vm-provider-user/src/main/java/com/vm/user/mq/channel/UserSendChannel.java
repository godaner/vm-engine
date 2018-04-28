package com.vm.user.mq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by ZhangKe on 2018/4/27.
 */
public interface UserSendChannel {

    String USER_OUTPUT = "userOutput";

    @Output(UserSendChannel.USER_OUTPUT)
    MessageChannel userOutput();
}
