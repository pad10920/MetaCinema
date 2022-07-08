package com.example.cinema.api;

import com.example.cinema.dao.PhongChieuDAO;
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

@WebServlet(name = "PhongChieuAPI", value = "/api/phong/*")
@MultipartConfig
public class PhongChieuAPI extends HttpServlet {
    private PhongChieuDAO phongChieuDAO = new PhongChieuDAO();
    private Gson gson = new Gson();
    /*url: http://localhost:8080/Cinema/api/phong/1
    * Lấy thông tin phòng chiếu*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Pattern pattern = Pattern.compile("api/phong/(\\d++)$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        if(matcher.find()){
            int id = Integer.parseInt(matcher.group(1));
            String json = gson.toJson(phongChieuDAO.getPhongChieuByID(id));
            out.print(json);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
