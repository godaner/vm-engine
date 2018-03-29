package com.vm.src.service.exception;

import com.vm.base.service.exception.VmRuntimeException;

/**
 * Created by ZhangKe on 2018/1/9.
 */
public class VmSrcException extends VmRuntimeException {


    public VmSrcException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public VmSrcException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg, errorCode, errorMsg);
    }

    public VmSrcException(String logMsg) {
        super(logMsg);
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
