package com.example.cinema.api;

import com.example.cinema.dao.RapDAO;
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

@WebServlet(name = "RapAPI", value = "/api/rap/*")
@MultipartConfig
public class RapAPI extends HttpServlet {
    private RapDAO rapDAO = new RapDAO();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Pattern pattern = Pattern.compile("api/rap$");
        Matcher matcher = pattern.matcher(request.getRequestURL());

        Pattern pattern1 = Pattern.compile("api/rap/(\\d++)$");
        Matcher matcher1 = pattern1.matcher(request.getRequestURL());
        if(matcher.find()){
            out.print(gson.toJson(rapDAO.findAll()));
        }
        else if(matcher1.find()){
            int id = Integer.parseInt(matcher1.group(1));

            String json = gson.toJson(rapDAO.getRapByID(id));
            out.print(json);
        }
        else {
            out.print(0);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
