package com.zldx.servlet;

import com.zldx.pojo.ResultData;
import com.zldx.service.LoginService;
import com.zldx.service.impl.LoginImpl;
import com.zldx.utils.CookieUtils;
import com.zldx.utils.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //请求格式修改
        req.setCharacterEncoding("utf-8");
        //响应格式修改成json
        resp.setContentType("application/json;charset=utf-8");
        //1、处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String remember = req.getParameter("rememberMe");
        //验证码
        String text = (String) req.getSession().getAttribute("text");
        if(code == null || !code.equalsIgnoreCase(text)){
            ResultData resultData = new ResultData(100,"验证码不正确");
            //3、做出响应
            String json = JSONUtils.objToString(resultData);
            resp.getWriter().write(json);
            return;
        }

        //2、调用业务层登录确定
        LoginService loginimp = new LoginImpl();
        ResultData loginData = loginimp.login(username, password);
        if (loginData.getCode()==0){//表示登录成功
            if (remember!=null){//勾选了记住
                //将用户名和密码以username-password的格式保存到Cookie中
                CookieUtils.setCookie("cookieUser",username+"-"+password,req,resp);
            }
            req.getSession().setAttribute("loginUser",loginData.getData());
        }

        //3、做出响应
        String json = JSONUtils.objToString(loginData);
        resp.getWriter().write(json);


        //判断做出相应
//        if (user !=null){
//            if (remember != null){//勾选返回on，不勾为null
//                //保存账号密码到cookie
//                CookieUtils.setCookie("username", username, req, resp);
//                CookieUtils.setCookie("password", password, req, resp);
//            }else {//否则记得清空
//                CookieUtils.removeCookie("username",req,resp);
//                CookieUtils.removeCookie("password",req,resp);
//            }
//            //登录成功保存session用户状态
//            req.getSession().setAttribute("loginUser",user);
//
//            resp.sendRedirect(req.getContextPath()+"/jump.do");//跳转功能页面
//        }else {//登录失败操作
//            req.setAttribute("loginError","用户名密码不正确");
//            req.getRequestDispatcher("login.jsp").forward(req,resp);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
