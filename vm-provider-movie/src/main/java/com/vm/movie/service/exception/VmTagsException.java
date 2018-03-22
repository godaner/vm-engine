package com.vm.movie.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/1/9.
 */
public class VmTagsException extends VmRuntimeException {


    public VmTagsException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmTagsException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmTagsException(String logMsg) {
        super(logMsg);
    }

    public enum ErrorCode {
        TAG_IS_NOT_EXITS(-1, "标签不存在"),
        TAG_NAME_IS_NOT_EXITS(-2, "标签名已存在");
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
