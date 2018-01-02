package com.vm.frontend.ws;

import com.alibaba.fastjson.JSONObject;
import com.vm.base.utils.ByteConstantVar;
import com.vm.base.utils.CommonUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UsersWsController extends CommonUtil {
    @MessageMapping("/ws/user/login")
    @SendTo("/ws/user/res/login")
    public String userLogin(String msg) throws Exception {
        Message message = JSONObject.parseObject(msg, Message.class);
        return msg;
    }


    /**
     * 定义信息格式
     */
    private class Message {
        private Byte operation;
        private Long fromUserId;

        public Byte getOperation() {
            return operation;
        }

        public void setOperation(Byte operation) {
            this.operation = operation;
        }

        public Long getFromUserId() {
            return fromUserId;
        }

        public void setFromUserId(Long fromUserId) {
            this.fromUserId = fromUserId;
        }
    }

    /**
     * 操作
     */
    private enum Operation {
        LOGIN(ByteConstantVar.ONE, "登录"),
        LOGOUT(ByteConstantVar.TWO, "注销");

        Byte code;

        String msg;

        Operation(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


        public static final boolean isLogin(Byte code) {
            return LOGIN.getCode().equals(code);
        }

        public static final boolean isLogout(Byte code) {
            return LOGOUT.getCode().equals(code);
        }
    }
}