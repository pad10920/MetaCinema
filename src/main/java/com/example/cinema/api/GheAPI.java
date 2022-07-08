package com.example.cinema.api;

import com.example.cinema.dao.GheDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GheAPI", value = "/api/ghe/*")
@MultipartConfig
public class GheAPI extends HttpServlet {
    private GheDAO gheDAO = new GheDAO();
    private Gson gson = new Gson();

    /* url: http://localhost:8080/Cinema/api/ghe?suat-chieu=1*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int idSuatChieu = Integer.parseInt(request.getParameter("suat-chieu"));
        out.print(gson.toJson(gheDAO.getGheByIDSuatChieu(idSuatChieu)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        int idGhe = Integer.parseInt(request.getParameter("idGhe"));
        gheDAO.updateGhe(idGhe);
    }
}
