package com.example.cinema.api;

import com.example.cinema.dao.UserDAO;
import com.example.cinema.mapper.UserMapper;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "UserAPI", value = "/api/user/*")
@MultipartConfig
public class UserAPI extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Pattern pattern = Pattern.compile("api/user$");
        Matcher matcher = pattern.matcher(request.getRequestURL());
        if(matcher.find()){
            try{
                //url: api/user?id=1
                int idUser = Integer.parseInt(request.getParameter("id"));


                String password = request.getParameter("mat-khau");
                if(password != null){
                    out.println(userDAO.checkExitsPasswordByUser(idUser, password));
                }
                else{
                    out.println(gson.toJson(userDAO.getUserById(idUser)));
                }



            }
            catch (Exception e){
                response.sendError(404);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Pattern pattern = Pattern.compile("api/user$");
        Matcher matcher = pattern.matcher(request.getRequestURL());

        Pattern pattern1 = Pattern.compile("api/user/doi-mat-khau$");
        Matcher matcher1 = pattern1.matcher(request.getRequestURL());
        if(matcher.find()){
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String email = request.getParameter("email");
            UserMapper userMapper = new UserMapper(idUser, hoTen, diaChi, sdt, email);
            userDAO.update(userMapper);
            out.println(gson.toJson(userDAO.getUserById(idUser)));

        }

        //url api/user/doi-mat-khau
        else if(matcher1.find()){
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String passWord = request.getParameter("mat-khau");
            userDAO.updatePassWord(idUser, passWord);
        }





    }
}
