package com.vm.base.service.exception;

/**
 * Created by ZhangKe on 2018/3/29.
 */
public class VmCommonException extends  VmRuntimeException {
    public VmCommonException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmCommonException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmCommonException(String logMsg) {
        super(logMsg);
    }
    public enum ErrorCode {
        ADMIN_HAVE_NOT_AUTH(-555,"您没有权限进行此操作！"),
        ADMIN_IS_OFFLINE(-9999,"管理员已离线");

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
