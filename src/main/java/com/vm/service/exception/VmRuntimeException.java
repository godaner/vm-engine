package com.vm.service.exception;

import java.util.Map;

/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>
 * <br/>
 * <br/>
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/24 9:55
 */
public class VmRuntimeException extends RuntimeException {
    protected Long errorCode;
    protected Map params;

    public VmRuntimeException(Long errorCode, String message, Map params, Throwable e) {

        super(message, e);
        this.errorCode = errorCode;
        this.params = params;
    }

    public VmRuntimeException(Long errorCode, String message, Map data) {

        this(errorCode, message, data, null);
    }

    public VmRuntimeException(Long errorCode, String message) {
        this(errorCode, message, null, null);
    }

    public VmRuntimeException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg(), null, null);
    }

    public VmRuntimeException(String message) {

        this(ErrorCode.UNKNOWN.getCode(), message, null, null);
    }
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        if (getParams() != null) {
            Map args = getParams();
            for (Object object : args.keySet()) {
                String name = (String) object;
                sb.append(" " + name + ":").append(args.get(name)).append(";");
            }
        }
        return sb.toString();
    }


    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    /**
     * <b>Title:</b>
     * <br/>
     * <br/>
     * <b>Description:</b>错误枚举
     * <br/>
     * <br/>
     * <b>Author:</b>ZhangKe
     * <br/>
     * <br/>
     * <b>Date:</b>2017/11/24 9:58
     */
    public enum ErrorCode {
        UNKNOWN(10000L, "系统错误");
        private Long code;
        private String msg;

        ErrorCode(Long code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "ErrorCode{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    "} " + super.toString();
        }

        public Long getCode() {
            return code;
        }

        public void setCode(Long code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        ErrorCode() {

        }
    }
}
