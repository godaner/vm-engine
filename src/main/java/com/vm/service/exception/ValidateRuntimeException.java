package com.vm.service.exception;

import sun.misc.VM;

import java.util.Map;

/**
 * Created by liuke on 2017/5/23.
 */
public class ValidateRuntimeException extends VMRuntimeException{

    public ValidateRuntimeException(ErrorCode authErrorCode, Map object) {
        super(authErrorCode.getCode(), authErrorCode.getMsg(), object);
    }

    public enum ErrorCode {
        INVALID_QUERY_TYPE(10001L,"错误的查询类型"),
        INVALID_QUERY_JSON(10002L,"无效的查询条件"),
        INVALID_SYSTEM_TASK_TYPE(50003L,"任务类型错误"),
        INVALID_INPUT_DATA(10004L,"参数错误"),
        KEYWORD_ALREADY_EXISTS(10005L,"关键字已存在"),
        OBJECT_IS_NOT_EXISTS(10006L,"对象不存在");

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
