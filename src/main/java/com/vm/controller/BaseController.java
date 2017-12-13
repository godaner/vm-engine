package com.vm.controller;


import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by ZhangKe on 2017/11/24.
 */
public class BaseController {
    //响应对象
    protected Response response = new Response();
    //响应键值对
    protected Map<Object,Object> map = new ConcurrentHashMap<Object,Object>();
    /**
     * 设置req和res,方便使用
     */
    protected HttpServletRequest req;
    protected HttpServletResponse res;

    @ModelAttribute
    protected void initHttpAPI(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    /**
     * 设置session的参数
     *
     * @param name
     * @param value
     * @return
     */
    public Boolean setSessionAttr(String name, Object value) {
        try {
            getSession().setAttribute(name, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * 获取session的参数
     *
     * @param name
     * @return
     */
    public <T> T getSessionAttr(String name) {

        try {
            return (T) getSession().getAttribute(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 去除session的参数
     *
     * @param name
     * @return
     */
    public Boolean removeSessionAttr(String name) {

        try {
            getSession().removeAttribute(name);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 设置request的参数
     *
     * @param name
     * @param o
     * @return
     */
    public Boolean setRequestAttr(String name, Object o) {
        try {
            getRequest().setAttribute(name, o);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * 获取request的参数
     *
     * @param name
     * @return
     */
    public <T> T getRequestAttr(String name) {

        try {
            return (T) getRequest().getAttribute(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取request的请求参数
     *
     * @param name
     * @return
     */
    public <T> T getRequestParam(String name) {

        try {
            return (T) getRequest().getParameter(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 去除request的参数
     *
     * @param name
     * @return
     */
    public Boolean removeRequestAttr(String name) {

        try {
            getRequest().removeAttribute(name);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 设置Application的参数
     *
     * @param name
     * @param o
     * @return
     */
    public Boolean setApplicationAttr(String name, Object o) {
        try {
            getApplication().setAttribute(name, o);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * 获取Application的参数
     *
     * @param name
     * @return
     */
    public <T> T getApplicationAttr(String name) {

        try {
            return (T) getApplication().getAttribute(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 去除Application的参数
     *
     * @param name
     * @return
     */
    public Boolean removeApplicationAttr(String name) {

        try {
            getApplication().removeAttribute(name);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 获取session
     *
     * @return
     */
    public HttpSession getSession() {
        try {
            return req.getSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取request
     *
     * @return
     */
    public HttpServletRequest getRequest() {
        try {
            return req;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取response
     *
     * @return
     */
    public HttpServletResponse getResponse() {
        try {
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取application
     *
     * @return
     */
    public ServletContext getApplication() {
        try {
            return req.getServletContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
