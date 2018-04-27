package com.vm.mq.sender;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.Response;
import com.vm.mq.config.UserOnlineStatusSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/4/27.
 */
@Component
public class UserOnlineStatusMQSender extends CommonUtil {
    private final static Logger logger = LoggerFactory.getLogger(UserOnlineStatusMQSender.class);

    @Autowired
    @Output(UserOnlineStatusSource.OUTPUT)
    private MessageChannel channel;

    private static MessageChannel channelCache;


    @PostConstruct
    public void init() {
        channelCache = channel;
    }

    public final static void send(Object data) {


        String dataStr = gson.toJson(data);
        logger.info("AdminOnlineStatusMQSender send data is : " + dataStr);
        channelCache.send(MessageBuilder.withPayload(dataStr).build());
    }
    /**
     * 异地登陆提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginInOtherArea(String accessToken, Object newLoginRecord) {
        Response response = new Response();
        response.setCode(UserOnlineStatusMQSender.Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord", newLoginRecord);
        UserOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }

    /**
     * 登陆超时提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginTimeout(String accessToken) {
        Response response = new Response();
        response.setCode(UserOnlineStatusMQSender.Code.USER_LOGIN_TIMEOUT.getCode());
        response.setMsg(UserOnlineStatusMQSender.Code.USER_LOGIN_TIMEOUT.getMsg());
        response.putData("time", now());
        UserOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }


    /**
     * 冻结提示
     *
     * @param accessToken
     */
    public final static void tipUserIsFrozened(String accessToken) {
        Response response = new Response();
        response.setCode(UserOnlineStatusMQSender.Code.USER_IS_FROZENED.getCode());
        response.setMsg(UserOnlineStatusMQSender.Code.USER_IS_FROZENED.getMsg());
        response.putData("time", now());
        UserOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }

    /**
     * 删除提示
     *
     * @param accessToken
     */
    public final static void tipUserIsDeleted(String accessToken) {
        Response response = new Response();
        response.setCode(UserOnlineStatusMQSender.Code.USER_IS_DELETED.getCode());
        response.setMsg(UserOnlineStatusMQSender.Code.USER_IS_DELETED.getMsg());
        response.putData("time", now());
        UserOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }

    /**
     * 基本信息更新提示
     *
     * @param accessToken
     */
    public final static void tipUserInfoIsUpdated(String accessToken, Object newUser) {
        Response response = new Response();
        response.setCode(UserOnlineStatusMQSender.Code.USER_INFO_IS_UPDATED.getCode());
        response.setMsg(UserOnlineStatusMQSender.Code.USER_INFO_IS_UPDATED.getMsg());
        response.putData("time", now());
        response.putData("newUser", newUser);
        UserOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }


    public enum Code {
        USER_IS_LOGIN_IN_OTHER_AREA(-1, "账户正在异地登陆"),
        USER_LOGIN_TIMEOUT(-2, "账户登陆超时"),
        USER_IS_FROZENED(-3, "被冻结"),
        USER_IS_DELETED(-4, "被删除"),
        USER_INFO_IS_UPDATED(-5, "账户信息被更新");

        int code;
        String msg;

        Code(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }
}
