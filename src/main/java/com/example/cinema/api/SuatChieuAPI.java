package com.example.cinema.api;

import com.example.cinema.dao.SuatChieuDAO;
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

@WebServlet(name = "SuatChieuAPI", value = "/api/suat-chieu/*")

@MultipartConfig
public class SuatChieuAPI extends HttpServlet {

    //api/suat-chieu/
    private SuatChieuDAO suatChieuDAO = new SuatChieuDAO();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        /*
        * API toàn bộ suất chiếu: http://localhost:8080/Cinema/api/suat-chieu
        * API suất chiếu theo thời gian: http://localhost:8080/Cinema/api/suat-chieu/2022-05-25
        * */
        Pattern pattern = Pattern.compile("api/suat-chieu$");
        Matcher matcher = pattern.matcher(request.getRequestURL());


        Pattern pattern1 = Pattern.compile("api/suat-chieu/(\\d{4}-\\d{2}-\\d{2})$");
        Matcher matcher1 = pattern1.matcher(request.getRequestURL());

        Pattern pattern2 = Pattern.compile("api/suat-chieu/phim/(\\d++)$");
        Matcher matcher2 = pattern2.matcher(request.getRequestURL());

        Pattern pattern3 = Pattern.compile("phim=(\\d+)&ngay=(\\d{4}-\\d{2}-\\d{2})$");
        Matcher matcher3 = null;

        Pattern pattern4 = Pattern.compile("api/suat-chieu/(\\d++)$");
        Matcher matcher4 = pattern4.matcher(request.getRequestURL());

        if(matcher.find()){

           if(request.getQueryString() != null){
               String sid = request.getParameter("phim");

               String ngay = request.getParameter("ngay");
               if(sid == null){

                   out.print(gson.toJson(suatChieuDAO.getSuatChieuByNgay(ngay)));
               }
               else{
                   int id = Integer.parseInt(sid);
                   out.println(gson.toJson(suatChieuDAO.getSuatChieuByPhimAndDate(id, ngay)));
               }

            }
            else{
                out.print(gson.toJson(suatChieuDAO.findAll()));
            }
        }

        else if(matcher1.find()){
            String date = matcher1.group(1);
            out.print(gson.toJson(suatChieuDAO.getSuatChieuByDate(date)));

        }
        else if(matcher2.find()){
            int idPhim = Integer.parseInt(matcher2.group(1));
            out.println(gson.toJson(suatChieuDAO.getSuatChieyByIDPhim(idPhim)));
        }
        else if(matcher4.find()){
            int idSuatChieu = Integer.parseInt(matcher4.group(1));
            out.print(gson.toJson(suatChieuDAO.getSuatChieuByID(idSuatChieu)));
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
