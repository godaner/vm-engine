package com.vm.base.util;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Response implements Serializable {

    private final static Gson gson = new Gson();
    private static final long serialVersionUID = 7247714616080613254L;

    private int code;
    private Map<Object, Object> data = new HashMap<Object, Object>();
    private String msg;

    public boolean isFailure() {
        return this.code == ResponseCode.FAILURE.getCode();
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public Response() {
        super();
        setSuccess();
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

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map getData() {
        return data;
    }

    public Object getData(Object key) {
        if (data.containsKey(key)) {
            return data.get(key);
        } else {
            return new Object();
        }
    }

    public Response setData(Map<Object, Object> data) {
        this.data = data;
        return this;
    }

    public Response putData(Object key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Response setFailure() {
        this.setCode(ResponseCode.FAILURE.getCode());
        this.setMsg(ResponseCode.FAILURE.getMsg());
        this.data.clear();
        return this;
    }

    public Response setFailure(ResponseCode responseCodeEnum) {
        this.setCode(responseCodeEnum.getCode());
        this.setMsg(responseCodeEnum.getMsg());
        this.data.clear();
        return this;
    }

    public Response setSuccess() {
        this.setCode(ResponseCode.SUCCESS.getCode());
        this.setMsg(ResponseCode.SUCCESS.getMsg());
        return this;
    }


    public static final Response fromJSON(String res) {
        return gson.fromJson(res, Response.class);
    }

    public String toJSONString() {
        return gson.toJson(this);
    }

    /**
     * <b>Title:</b>
     * <br/>
     * <br/>
     * <b>Description:</b>响应异常
     * <br/>
     * <br/>
     * <b>Author:</b>ZhangKe
     * <br/>
     * <br/>
     * <b>Date:</b>2017/11/24 10:03
     */
    public enum ResponseCode {

        //通用
        SUCCESS(1, "请求成功"),
        FAILURE(-1, "系统错误");

        int code;
        String msg;

        ResponseCode(int code, String msg) {
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

        ResponseCode() {

        }
    }

}
