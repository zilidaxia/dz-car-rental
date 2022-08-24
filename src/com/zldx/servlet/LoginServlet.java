package com.zldx.servlet;

import com.zldx.pojo.User;
import com.zldx.service.LoginService;
import com.zldx.service.impl.LoginImpl;
import com.zldx.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remerber = req.getParameter("remerber");
        //调用业务层
        LoginService loginimp = new LoginImpl();
        User user = loginimp.login(username, password);
        //判断做出相应
        if (user !=null){
            if (remerber != null){//勾选返回on，不勾为null
                //保存账号密码到cookie
                CookieUtils.setCookie("username", username, req, resp);
                CookieUtils.setCookie("password", password, req, resp);
            }else {//否则记得清空
                CookieUtils.removeCookie("username",req,resp);
                CookieUtils.removeCookie("password",req,resp);
            }
            //登录成功保存session用户状态
            req.getSession().setAttribute("loginUser",user);

            resp.sendRedirect(req.getContextPath()+"/jump.do");//跳转功能页面
        }else {//登录失败操作
            req.setAttribute("loginError","用户名密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
