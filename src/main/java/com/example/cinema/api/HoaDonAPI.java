package com.example.cinema.api;

import com.example.cinema.dao.HoaDonDAO;
import com.example.cinema.dao.UserDAO;
import com.example.cinema.model.HoaDon;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "HoaDonAPI", value = "/api/hoa-don/*")
@MultipartConfig
public class HoaDonAPI extends HttpServlet {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private UserDAO userDAO = new UserDAO();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int IdUser = Integer.parseInt(request.getParameter("id-user"));
        out.print(gson.toJson(hoaDonDAO.getHoaDonByIDUser(IdUser)));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayMua(sqlDate);
        hoaDon.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));
        hoaDon.setTongTien(Integer.parseInt(request.getParameter("tongTien")));
        hoaDon.setUser(userDAO.getUserById(Integer.parseInt(request.getParameter("idUser"))));
        out.println(hoaDonDAO.insertHoaDon(hoaDon));
    }
}
