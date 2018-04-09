package com.vm.user.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/1/9.
 */
public class VmUsersException extends VmRuntimeException {


    public VmUsersException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmUsersException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmUsersException(String logMsg) {
        super(logMsg);
    }

    public enum ErrorCode {
        USER_IS_NOT_EXITS(-1, "账户不存在"),
        PASSWORD_ERROR(-2, "密码错误"),
        USER_HEAD_IMG_CONTENT_TYPE_ERROR(-3, "用户头像文件格式错误"),
        USER_HEAD_IMG_WIDTH_IS_NULL(-4, "缺少用户头像大小参数"),
        USERNAME_IS_EXITS(-6,"用户名已存在");

        int code;
        String msg;

        ErrorCode(int code, String msg) {
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
