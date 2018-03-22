package com.vm.movie.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/3/21.
 */
public class VmTagGroupsException extends VmRuntimeException {
    public VmTagGroupsException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmTagGroupsException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmTagGroupsException(String logMsg) {
        super(logMsg);
    }

    public enum ErrorCode {
        TAG_GROUP_NAME_IS_EXITS(-1, "标签分组名已存在"),
        TAG_GROUP_IS_NOT_EXITS(-2, "标签分组不存在");
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
