package com.vm.admin.ws;

import com.vm.base.util.BaseWSController;
import com.vm.base.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Controller
public class AdminOnlineStatusWSController extends BaseWSController {
    protected static Logger logger = LoggerFactory.getLogger(AdminOnlineStatusWSController.class);


    /**
     * 异地登陆提示
     *
     * @param accessToken
     */
    public final static void tipLogoutWhenUserLoginInOtherArea(String accessToken, Object newLoginRecord) {
        Response response = new Response();
        response.setCode(Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord", newLoginRecord);
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
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
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
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
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    /**
     * 冻结提示
     *
     * @param accessToken
     */
    public final static void tipAdminIsFrozened(String accessToken) {
        Response response = new Response();
        response.setCode(Code.ADMIN_IS_FROZENED.getCode());
        response.setMsg(Code.ADMIN_IS_FROZENED.getMsg());
        response.putData("time", now());
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    /**
     * 删除提示
     *
     * @param accessToken
     */
    public final static void tipAdminIsDeleted(String accessToken) {
        Response response = new Response();
        response.setCode(Code.ADMIN_IS_DELETED.getCode());
        response.setMsg(Code.ADMIN_IS_DELETED.getMsg());
        response.putData("time", now());
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    /**
     * 基本信息更新提示
     *
     * @param accessToken
     */
    public final static void tipAdminInfoIsUpdated(String accessToken, Object newAdmin) {
        Response response = new Response();
        response.setCode(Code.ADMIN_INFO_IS_UPDATED.getCode());
        response.setMsg(Code.ADMIN_INFO_IS_UPDATED.getMsg());
        response.putData("time", now());
        response.putData("newAdmin", newAdmin);
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    public enum Code {
        USER_IS_LOGIN_IN_OTHER_AREA(-1, "账户正在异地登陆"),
        USER_LOGIN_TIMEOUT(-2, "账户登陆超时"),
        UPDATE_MENU_TREE(-3, "菜单更新"),
        ADMIN_IS_FROZENED(-4, "被冻结"),
        ADMIN_IS_DELETED(-5, "被删除"),
        ADMIN_INFO_IS_UPDATED(-6, "账户信息被更新");

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