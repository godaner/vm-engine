package com.vm.mq.sender;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.Response;
import com.vm.mq.config.AdminOnlineStatusSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/4/27.
 */
@Component
@EnableBinding(AdminOnlineStatusSource.class)
public class AdminOnlineStatusMQSender extends CommonUtil {

    private final static Logger logger = LoggerFactory.getLogger(AdminOnlineStatusMQSender.class);

    @Autowired
    @Output(AdminOnlineStatusSource.OUTPUT)
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
        response.setCode(AdminOnlineStatusMQSender.Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord", newLoginRecord);
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
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
        response.setCode(AdminOnlineStatusMQSender.Code.USER_LOGIN_TIMEOUT.getCode());
        response.setMsg(AdminOnlineStatusMQSender.Code.USER_LOGIN_TIMEOUT.getMsg());
        response.putData("time", now());
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
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
        response.setCode(AdminOnlineStatusMQSender.Code.USER_IS_FROZENED.getCode());
        response.setMsg(AdminOnlineStatusMQSender.Code.USER_IS_FROZENED.getMsg());
        response.putData("time", now());
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
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
        response.setCode(AdminOnlineStatusMQSender.Code.USER_IS_DELETED.getCode());
        response.setMsg(AdminOnlineStatusMQSender.Code.USER_IS_DELETED.getMsg());
        response.putData("time", now());
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }

    /**
     * 菜单更新提示
     *
     * @param accessToken
     */
    public final static void tipAdminUpdateMenu(String accessToken, Object newMenuTree) {
        Response response = new Response();
        response.setCode(Code.UPDATE_MENU_TREE.getCode());
        response.setMsg(Code.UPDATE_MENU_TREE.getMsg());
        response.putData("newMenuTree", newMenuTree);
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
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
        response.setCode(AdminOnlineStatusMQSender.Code.USER_INFO_IS_UPDATED.getCode());
        response.setMsg(AdminOnlineStatusMQSender.Code.USER_INFO_IS_UPDATED.getMsg());
        response.putData("time", now());
        response.putData("newUser", newUser);
        AdminOnlineStatusMQSender.send(ImmutableMap.of(
                "accessToken", accessToken,
                "response", response
        ));
    }


    public enum Code {
        USER_IS_LOGIN_IN_OTHER_AREA(-1, "账户正在异地登陆"),
        USER_LOGIN_TIMEOUT(-2, "账户登陆超时"),
        UPDATE_MENU_TREE(-3, "菜单更新"),
        USER_IS_FROZENED(-4, "被冻结"),
        USER_IS_DELETED(-5, "被删除"),
        USER_INFO_IS_UPDATED(-6, "账户信息被更新");

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
