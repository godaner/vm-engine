package com.vm.user.ws;

import com.vm.base.util.BaseWSController;
import com.vm.base.util.Response;
import org.springframework.stereotype.Controller;


@Controller
public class UserOnlineStatusWSController extends BaseWSController {

    /**
     * 异地登陆提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginInOtherArea(String accessToken, Object newLoginRecord) {
        Response response = new Response();
        response.setCode(Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord", newLoginRecord);
        UserOnlineStatusWSController.sendToUser(accessToken, "/userOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    /**
     * 登陆超时提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginTimeout(String accessToken) {
        Response response = new Response();
        response.setCode(Code.USER_LOGIN_TIMEOUT.getCode());
        response.setMsg(Code.USER_LOGIN_TIMEOUT.getMsg());
        response.putData("time", now());
        UserOnlineStatusWSController.sendToUser(accessToken, "/userOnlineStatus", response); //一对一发送，发送特定的客户端
    }


    /**
     * 冻结提示
     *
     * @param accessToken
     */
    public final static void tipUserIsFrozened(String accessToken) {
        Response response = new Response();
        response.setCode(Code.USER_IS_FROZENED.getCode());
        response.setMsg(Code.USER_IS_FROZENED.getMsg());
        response.putData("time", now());
        UserOnlineStatusWSController.sendToUser(accessToken, "/userOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    /**
     * 删除提示
     *
     * @param accessToken
     */
    public final static void tipUserIsDeleted(String accessToken) {
        Response response = new Response();
        response.setCode(Code.USER_IS_DELETED.getCode());
        response.setMsg(Code.USER_IS_DELETED.getMsg());
        response.putData("time", now());
        UserOnlineStatusWSController.sendToUser(accessToken, "/userOnlineStatus", response); //一对一发送，发送特定的客户端
    }
    /**
     * 基本信息更新提示
     *
     * @param accessToken
     */
    public final static void tipUserInfoIsUpdated(String accessToken, Object newUser) {
        Response response = new Response();
        response.setCode(Code.USER_INFO_IS_UPDATED.getCode());
        response.setMsg(Code.USER_INFO_IS_UPDATED.getMsg());
        response.putData("time", now());
        response.putData("newUser", newUser);
        UserOnlineStatusWSController.sendToUser(accessToken, "/userOnlineStatus", response); //一对一发送，发送特定的客户端
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