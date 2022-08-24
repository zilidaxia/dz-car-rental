package com.zldx.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServletContext extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象的三种方式

        //ServletContext servletContext = this.getServletContext();
        //ServletContext servletContext = req.getServletContext();

        ServletContext servletContext = req.getSession().getServletContext();
        System.out.println(servletContext.getAttribute("application"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}