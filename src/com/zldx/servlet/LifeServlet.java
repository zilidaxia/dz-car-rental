package com.zldx.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeServlet extends HttpServlet {
    String msg;
    public LifeServlet(){
        System.out.println("Servlet被创建");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet被初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName()+"Servlet被执行");
        synchronized (this){
            msg=req.getParameter("msg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            resp.getWriter().write(msg);        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet被销毁");
    }
}
