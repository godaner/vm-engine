package com.vm.admin.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmAdminException extends VmRuntimeException {
    public VmAdminException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmAdminException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmAdminException(String logMsg) {
        super(logMsg);
    }
    public enum ErrorCode {
        USERNAME_IS_EXITS(-1,"用户名已存在"),
        CAN_NOT_OPERATE_IMMUTABLE(-2,"不可操作内置对象");

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
