package com.zldx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("*.do")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求的路径req.getRequestURI()
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //判断Session是否保存user对象，如果不为null表示登陆过，则放行，否则跳转登录界面
        HttpSession session = req.getSession();
        Object user = session.getAttribute("loginUser");
        if (user!=null){
            filterChain.doFilter(req,resp);
        }else {
            req.setAttribute("loginError","请先登录!!!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

}
