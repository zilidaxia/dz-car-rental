package com.zldx.test;

import com.zldx.service.impl.LoginImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        LoginImpl login = new LoginImpl();
//        System.out.println(login.login("123","123"));
        System.out.println(URLDecoder.decode(URLEncoder.encode("曹自力", "UTF-8"), "gbk"));
    }
}
