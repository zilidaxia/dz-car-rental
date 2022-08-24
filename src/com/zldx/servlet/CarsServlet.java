package com.zldx.servlet;

import com.zldx.pojo.PageBean;
import com.zldx.service.CarsService;
import com.zldx.service.impl.CarsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Cars.do")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、处理请求
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        //2、调用业务层方法
        CarsService carsService = new CarsServiceImpl();
        PageBean pageBean = carsService.selectPage(pageNum, pageSize);
        //3、做出响应  将数据保存到request域中，再转发到emp.jsp页面
        req.setAttribute("pageBean",pageBean);
        req.getRequestDispatcher("/cars.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
