package com.zldx.servlet;

import com.zldx.pojo.ResultData;
import com.zldx.service.impl.CarsServiceImpl;
import com.zldx.utils.JSONUtils;
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
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //1、获取请求参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

        //2、调用业务层方法
        CarsServiceImpl cs = new CarsServiceImpl();
        ResultData resultData = cs.selectAll(page, limit);


        //3、做出响应
        String json = JSONUtils.objToString(resultData);
        resp.getWriter().write(json);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
