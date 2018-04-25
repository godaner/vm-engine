package com.vm.admin.ws;

import com.vm.base.util.BaseWSController;
import com.vm.base.util.Response;
import org.springframework.stereotype.Controller;


@Controller
public class AdminOnlineStatusWSController extends BaseWSController {

    public final static void tipLogoutWhenUserLoginInOtherArea(String accessToken,Object newLoginRecord) {
        Response response = new Response();
        response.setCode(Code.USER_IS_LOGIN_IN_OTHER_AREA.getCode());
        response.putData("loginRecord",newLoginRecord);
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    public final static void tipLogoutWhenUserLoginTimeout(String accessToken) {
        Response response = new Response();
        response.setCode(Code.USER_LOGIN_TIMEOUT.getCode());
        response.setMsg(Code.USER_LOGIN_TIMEOUT.getMsg());
        AdminOnlineStatusWSController.sendToUser(accessToken, "/adminOnlineStatus", response); //一对一发送，发送特定的客户端
    }

    public enum Code {
        USER_IS_LOGIN_IN_OTHER_AREA(-1, "账户正在异地登陆"),
        USER_LOGIN_TIMEOUT(-2, "账户登陆超时");

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