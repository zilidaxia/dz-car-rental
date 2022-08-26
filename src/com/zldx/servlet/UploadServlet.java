package com.zldx.servlet;

import com.zldx.pojo.ResultData;
import com.zldx.utils.DateUtils;
import com.zldx.utils.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json,charset=utf-8");

        ResultData resultData;

        try {
            Part part = req.getPart("file");
            File file = new File("D:\\upload");
            if (!file.exists()){
                file.mkdirs();
            }
            String submittedFileName =part.getSubmittedFileName();
            String fileExt = submittedFileName.substring(submittedFileName.lastIndexOf("."));
            String filename= DateUtils.createId()+fileExt;
            part.write("D:\\upload\\"+filename);
            resultData= new ResultData(0, "上传成功", filename);

        } catch (ServletException e) {
            e.printStackTrace();
            resultData= new ResultData(100, "上传失败");
        }
        String json = JSONUtils.objToString(resultData);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
