package com.zldx.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static void setCookie(String name, String value, int maxAge, String path, HttpServletResponse response){
        //1、创建Cookie对象
        Cookie cookie = new Cookie(name,value);
        //2、设置Cookie
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        //3、响应Cookie到客户端浏览器
        response.addCookie(cookie);
    }
    public static void setCookie(String name, String value, HttpServletRequest request, HttpServletResponse response){
        setCookie(name,value,60*60*24*7,request.getContextPath(),response);
    }
    public static String getCookie(String name,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    public static void removeCookie(String name,HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }
}
