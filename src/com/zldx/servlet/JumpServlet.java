package com.zldx.servlet;

import com.zldx.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/jump.do")
public class JumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        if (loginUser.getType() == 0) {
            req.getRequestDispatcher(req.getContextPath()+"/UserMain.jsp").forward(req, resp);
        } else if (loginUser.getType() == 1) {
            req.getRequestDispatcher(req.getContextPath()+"/Manager.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
