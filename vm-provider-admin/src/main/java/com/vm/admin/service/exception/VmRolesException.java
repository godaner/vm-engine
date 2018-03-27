package com.vm.admin.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmRolesException extends VmRuntimeException {
    public VmRolesException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmRolesException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmRolesException(String logMsg) {
        super(logMsg);
    }
    public enum ErrorCode {
        ROLE_NAME_IS_EXITS(-1,"角色名已存在"),
        CAN_NOT_OPERATE_IMMUTABLE(-2,"不可操作内置对象"),
        ROLE_NAME_IS_NOT_EXITS(-3,"角色名不存在");

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
