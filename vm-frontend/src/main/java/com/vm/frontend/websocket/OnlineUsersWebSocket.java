package com.vm.frontend.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vm.base.utils.ByteConstantVar;
import com.vm.base.utils.CommonUtil;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/ws/user/status/{userId}")
public class OnlineUsersWebSocket extends CommonUtil {


    public static Map<Long, OnlineUsersWebSocket> onlineClients = new ConcurrentHashMap<Long, OnlineUsersWebSocket>();
    public static Map<Long, OnlineUsersWebSocket> cacheOfClients = new ConcurrentHashMap<Long, OnlineUsersWebSocket>();
    //websocket的session
    public Session session;
    private Long userId;

    private InMessage inMessage;

    private OutMessage outMessage;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen

    public void onOpen(@PathParam("userId") Long userId, Session session) throws Exception {

        this.session = session;

        this.userId = userId;

        //缓存所有客户端
        this.cacheOfClients.put(userId, this);

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws Exception {
//        userLogout(userId, OnlineUsersWebSocket.Result.LOGOUT_SUCCESS.getCode());
    }

    public static void userLogout(Long userId, Byte way) throws IOException {
        //注销原有client
        OnlineUsersWebSocket onlineUsersWs = onlineClients.get(userId);

        //移除客户端信息
        onlineClients.remove(userId);
        //通知客户端注销成功(可能是主动注销，可能是被动注销：包括session超时，账户在其他地方登录)
        OutMessage message = new OutMessage();
        message.setUserId(userId);
        message.setResult(way);
        sendMessage(onlineUsersWs, JSON.toJSONString(message));
        logger.info("OnlineUsersWebSocket userLogout success ! userId is : {} , message is : {}", userId, message);
    }
    public void close() throws IOException {
        this.session.close();
    }

    public static void userLogin(Long userId) throws IOException {

        OnlineUsersWebSocket client = cacheOfClients.get(userId);

        onlineClients.put(userId, client);

        //通知客户端登陆成功
        OutMessage message = new OutMessage();
        message.setUserId(userId);
        message.setResult(OnlineUsersWebSocket.Result.LOGIN_SUCCESS.getCode());
        sendMessage(client, JSON.toJSONString(message));
        logger.info("OnlineUsersWebSocket userLogin success ! userId is : {} , message is : {}", userId, message);
    }

    /**
     * 发生错误时调用
     *
     * @param error
     */
    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }


    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String msg) throws Exception {
        InMessage inMessage = JSONObject.parseObject(msg, InMessage.class);
        logger.info("OnlineUsersWebSocket onMessage success ! inMessage is : {}", inMessage);

    }

    /**
     * Title:
     * <p>
     * Description:发送信息
     * <p>
     *
     * @param message
     * @throws IOException
     * @author Kor_Zhang
     * @date 2017年10月7日 下午2:20:58
     * @version 1.0
     */
    public void sendMessage(String message) throws IOException {
        sendMessage(this, message);
    }

    /**
     * Title:
     * <p>
     * Description:发送信息
     * <p>
     *
     * @param message
     * @throws IOException
     * @author Kor_Zhang
     * @date 2017年10月7日 下午2:20:58
     * @version 1.0
     */
    public static void sendMessage(OnlineUsersWebSocket onlineUserWs, String message) throws IOException {
        if (isNullObject(onlineUserWs) || isNullObject(onlineUserWs.session)) {
            return;
        }
        if (onlineUserWs.session.isOpen()) {
            onlineUserWs.session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 操作
     */
    public enum Operation {
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

    /**
     * 结果
     */
    public enum Result {
        LOGIN_SUCCESS(ByteConstantVar.ONE, "登录成功"),
        LOGIN_FAILURE(ByteConstantVar.ONE, "登录失败"),
        LOGOUT_SUCCESS(ByteConstantVar.THREE, "注销成功"),
        LOGOUT_FAILURE(ByteConstantVar.FOUR, "注销失败"),
        LOGIN_OTHER_AREA(ByteConstantVar.FIVE, "账户在其他地方登录"),
        SESSION_TIMEOUT(ByteConstantVar.SIX, "会话超时");

        Byte code;

        String msg;

        Result(Byte code, String msg) {
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
    }

}

/**
 * 定义信息格式
 */
class InMessage {
    private Byte operation;
    private Long userId;

    public InMessage() {
    }

    public Byte getOperation() {
        return operation;
    }

    public void setOperation(Byte operation) {
        this.operation = operation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}

class OutMessage {
    private Byte result;
    private Long userId;


    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OutMessage() {

    }


}