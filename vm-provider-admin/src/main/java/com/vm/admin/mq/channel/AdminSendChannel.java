package com.vm.admin.mq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by ZhangKe on 2018/4/27.
 */
public interface AdminSendChannel {

    String ADMIN_OUTPUT = "adminOutput";

    @Output(AdminSendChannel.ADMIN_OUTPUT)
    MessageChannel adminOutput();
}
