package com.vm.service.exception;

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
public class VMException extends RuntimeException{
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
    public enum ExceptionCode{
        UNKNOWN_EXCEPTION(1l,"未知异常");
        private Long code;
        private String msg;

        ExceptionCode(Long code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "ExceptionCode{" +
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

        ExceptionCode() {

        }
    }
}
