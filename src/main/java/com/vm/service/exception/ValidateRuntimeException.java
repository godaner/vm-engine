package com.vm.service.exception;

import java.util.Map;


public class ValidateRuntimeException extends VmRuntimeException {

    public ValidateRuntimeException(ErrorCode authErrorCode, Map object) {
        super(authErrorCode.getCode(), authErrorCode.getMsg(), object);
    }

    public enum ErrorCode {
        INVALID_PARAM(10001L,"参数错误"),
        OBJECT_IS_NOT_EXISTS(10002L,"对象不存在"),
        OBJECT_IS_EXISTS(10003L,"对象已存在");

         Long code;

         Long getCode() {
            return code;
        }

         void setCode(Long code) {
            this.code = code;
        }

         String getMsg() {
            return msg;
        }

         void setMsg(String msg) {
            this.msg = msg;
        }

         String msg;

        ErrorCode(Long code, String msg){
            this.code = code;
            this.msg = msg;
        }
    }
}
