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
}
