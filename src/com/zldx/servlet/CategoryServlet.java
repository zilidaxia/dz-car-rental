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

@WebServlet("/cate.do")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0、乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        //2、调用业务层方法
        CarsServiceImpl cs = new CarsServiceImpl();
        ResultData resultData = cs.selectAllCate();

        //3、响应数据
        String json = JSONUtils.objToString(resultData);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
