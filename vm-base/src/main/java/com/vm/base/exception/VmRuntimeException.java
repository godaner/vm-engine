package com.vm.base.exception;


import com.vm.base.util.Response;

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
    protected int errorCode;//=returnCode
    protected String errorMsg;//=returnMsg
    protected String logMsg;//=exception#getMessage()

    public VmRuntimeException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public VmRuntimeException(String logMsg, int errorCode, String errorMsg) {
        super(logMsg);
        this.logMsg = logMsg;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public VmRuntimeException(String logMsg) {
        super(logMsg);
        this.logMsg = logMsg;
        this.errorMsg = Response.ResponseCode.FAILURE.getMsg();
        this.errorCode = Response.ResponseCode.FAILURE.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }
}
