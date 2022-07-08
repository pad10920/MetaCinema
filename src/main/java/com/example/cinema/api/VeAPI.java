package com.example.cinema.api;

import com.example.cinema.dao.GheDAO;
import com.example.cinema.dao.HoaDonDAO;
import com.example.cinema.dao.SuatChieuDAO;
import com.example.cinema.dao.VeDAO;
import com.example.cinema.model.Ve;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VeAPI", value = "/api/ve/*")
@MultipartConfig
public class VeAPI extends HttpServlet {
    private GheDAO gheDAO = new GheDAO();
    private SuatChieuDAO suatChieuDAO = new SuatChieuDAO();
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private VeDAO veDAO = new VeDAO();
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(veDAO.getVeByIDUser(1)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int idGhe = Integer.parseInt(request.getParameter("idGhe"));
        int idSuatChieu = Integer.parseInt(request.getParameter("idSuatChieu"));
        int idHoaDon = Integer.parseInt(request.getParameter("idHoaDon"));
        Ve ve = new Ve();
        ve.setGhe(gheDAO.getGheByID(idGhe));
        ve.setSuatChieu(suatChieuDAO.getSuatChieuByID(idSuatChieu));
        ve.setHoaDon(hoaDonDAO.getHoaDonByID(idHoaDon));
        veDAO.insertVe(ve);
        out.println(gson.toJson(ve));
    }
}
