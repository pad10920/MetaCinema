package com.example.cinema.api;

import com.example.cinema.dao.LichSuDAO;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "LichSuAPI", value = "/api/lich-su/*")
public class LichSuAPI extends HttpServlet {
    private LichSuDAO lichSuDAO = new LichSuDAO();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Pattern pattern = Pattern.compile("api/lich-su$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        if(matcher.find()){
            int id = Integer.parseInt(request.getParameter("id-user"));
            out.println(gson.toJson(lichSuDAO.getLichSuByIDUser(id)));;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
