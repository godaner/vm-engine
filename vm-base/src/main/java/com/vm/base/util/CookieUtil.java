package com.vm.base.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    
    
    /**
     * 设置cookie
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse res, String name, String value, String domain, int maxAge){
        
        
        try {
            value = URLEncoder.encode(""+value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        Cookie cookie = new Cookie(name, value + "" );
        cookie.setPath("/");
        cookie.setDomain(domain);
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        res.addCookie(cookie);
    }
    
    /**
     * 根据名字获取cookie
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest req, String name){
        Map<String,Cookie> cookieMap = getCookieMap(req);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }   
    }
    
    /**
     * 将cookie封装到Map里面
     * @return
     */
    private static Map<String,Cookie> getCookieMap(HttpServletRequest req){  
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = req.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    
    public static boolean deleteCookie(HttpServletRequest req,HttpServletResponse res,String cookieName) {   
        if (cookieName != null) {
            Cookie cookie = getCookie(req,cookieName);   
            if(cookie!=null){
                cookie.setMaxAge(0);//0，就立即删除   
                cookie.setPath("/");//不要漏掉   
                cookie.setDomain(req.getServerName());
                res.addCookie(cookie);   
                return true;   
            }
        }   
        return false;   
    }

    public static String getValue(HttpServletRequest req,String cookieName){
        Cookie cookie = getCookie(req,cookieName);
        return getValue(cookie);
    }
    
    public static String getValue(Cookie cookie){
        if(null == cookie) return null;
        try {
            return URLDecoder.decode(cookie.getValue(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Cookie getCookie(HttpServletRequest req,String cookieName){   
        Cookie[] cookies = req.getCookies();   
        Cookie cookie = null;   
        try {
            if (cookies != null && cookies.length > 0) {   
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];   
                    if (cookie.getName().equals(cookieName)) {   
                        return cookie;   
                    }   
                }   
            }   
        } catch (Exception e) {  
            e.printStackTrace();   
        }
        return null;   
    }   
                                    
}