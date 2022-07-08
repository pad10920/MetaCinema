package com.example.cinema.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ThongTinTaiKhoanController", value = "/thong-tin/*")
public class ThongTinTaiKhoanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Pattern pattern = Pattern.compile("api/user/thong-tin$");
//        Matcher matcher = pattern.matcher(request.getRequestURL());
//        if(matcher.find()){
            request.getRequestDispatcher("view/thongTinTaiKhoan.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
