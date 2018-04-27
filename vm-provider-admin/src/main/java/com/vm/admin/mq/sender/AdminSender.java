package com.vm.admin.mq.sender;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.config.AdminSendChannel;
import com.vm.base.util.CommonUtil;
import com.vm.base.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/4/27.
 */
@Service
public class AdminSender extends CommonUtil {

    private final static Logger logger = LoggerFactory.getLogger(AdminSender.class);
    @Autowired
    private AdminSendChannel adminSendChannel;

    private static AdminSendChannel adminSendChannelCache;

    @PostConstruct
    public void init() {
        adminSendChannelCache = adminSendChannel;
    }

    public final static void send( Object data) {
        String dataStr = gson.toJson(data);
        logger.info("AdminSender send data is : " + dataStr);
        adminSendChannelCache.adminOutput().send(MessageBuilder.withPayload(dataStr).build());
    }

    /**
     * 异地登陆提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginInOtherArea(String accessToken, Object newLoginRecord) {
        Response response = new Response();
        response.setCode(AdminSender.Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord", newLoginRecord);
        AdminSender.send(ImmutableMap.of(
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
        response.setCode(AdminSender.Code.USER_LOGIN_TIMEOUT.getCode());
        response.setMsg(AdminSender.Code.USER_LOGIN_TIMEOUT.getMsg());
        response.putData("time", now());
        AdminSender.send(ImmutableMap.of(
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
        response.setCode(AdminSender.Code.USER_IS_FROZENED.getCode());
        response.setMsg(AdminSender.Code.USER_IS_FROZENED.getMsg());
        response.putData("time", now());
        AdminSender.send(ImmutableMap.of(
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
        response.setCode(AdminSender.Code.USER_IS_DELETED.getCode());
        response.setMsg(AdminSender.Code.USER_IS_DELETED.getMsg());
        response.putData("time", now());
        AdminSender.send(ImmutableMap.of(
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
        AdminSender.send(ImmutableMap.of(
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
        response.setCode(AdminSender.Code.USER_INFO_IS_UPDATED.getCode());
        response.setMsg(AdminSender.Code.USER_INFO_IS_UPDATED.getMsg());
        response.putData("time", now());
        response.putData("newUser", newUser);
        AdminSender.send(ImmutableMap.of(
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
