package com.vm.service.exception;

import com.vm.controller.base.Response;

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
    protected int errorCode;
    protected Map params;

    public VmRuntimeException(int errorCode, String message, Map params, Throwable e) {

        super(message, e);
        this.errorCode = errorCode;
        this.params = params;
    }

    public VmRuntimeException(int errorCode, String message, Map data) {

        this(errorCode, message, data, null);
    }

    public VmRuntimeException(int errorCode, String message) {
        this(errorCode, message, null, null);
    }

    public VmRuntimeException(Response.ResponseCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg(), null, null);
    }

    public VmRuntimeException(String message) {

        this(Response.ResponseCode.FAILURE.getCode(), message, null, null);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
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


}
