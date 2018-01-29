package com.vm.movie.service.exception;

import com.vm.base.exception.VmRuntimeException;
import com.vm.base.util.Response;

import java.util.Map;

/**
 * Created by ZhangKe on 2018/1/9.
 */
public class VmTagsException extends VmRuntimeException {
    public VmTagsException(int errorCode, String message, Map params, Throwable e) {
        super(errorCode, message, params, e);
    }

    public VmTagsException(int errorCode, String message, Map data) {
        super(errorCode, message, data);
    }

    public VmTagsException(int errorCode, String message) {
        super(errorCode, message);
    }

    public VmTagsException(Response.ResponseCode errorCode) {
        super(errorCode);
    }

    public VmTagsException(String message) {
        super(message);
    }

    public enum ErrorCode {
;
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
