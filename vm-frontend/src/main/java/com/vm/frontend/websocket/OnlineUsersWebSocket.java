package com.vm.frontend.websocket;

import com.alibaba.fastjson.JSON;
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
@ServerEndpoint("/ws/user/login/{userId}")
public class OnlineUsersWebSocket extends CommonUtil {

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static Map<Long, OnlineUsersWebSocket> clients = new ConcurrentHashMap<Long, OnlineUsersWebSocket>();

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

        //移除原有登录信息（原有用户将被破下线）
        userLogout(userId,OutMessage.Result.LOGIN_OTHER_AREA.getCode());
        //储存新的登录信息
        userLogin(userId);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws Exception {
        userLogout(userId,OutMessage.Result.LOGOUT_SUCCESS.getCode());
    }

    public static void userLogout(Long userId, Byte way) throws IOException {
        //注销原有client
        OnlineUsersWebSocket onlineUsersWs = clients.get(userId);

        //移除客户端信息
        clients.remove(userId);
        //通知客户端注销成功(可能是主动注销，可能是被动注销：包括session超时，账户在其他地方登录)
        OutMessage message = new OutMessage();
        message.setToUserId(userId);
        message.setResult(way);
        sendMessage(onlineUsersWs, JSON.toJSONString(message));
    }

    private void userLogin(Long userId) throws IOException {

        clients.put(userId, this);

        //通知客户端登陆成功
        OutMessage message = new OutMessage();
        message.setToUserId(userId);
        message.setResult(OutMessage.Result.LOGIN_SUCCESS.getCode());
        sendMessage(this, JSON.toJSONString(message));
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

    /********************************************功能性方法****************************************************/

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String msg) throws Exception {


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
        if (isNullObject(onlineUserWs)) {
            return;
        }
        onlineUserWs.session.getAsyncRemote().sendText(message);
    }


}

/**
 * 定义信息格式
 */
class InMessage {
    private Byte operation;
    private Long fromUserId;

    public InMessage() {
    }

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
}

class OutMessage {
    private Byte result;
    private Long toUserId;

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public OutMessage() {

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
        SESSION_TIMEOUT(ByteConstantVar.FIVE, "会话超时");

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