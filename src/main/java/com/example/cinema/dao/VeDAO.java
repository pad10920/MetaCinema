package com.example.cinema.dao;

import com.example.cinema.model.Ve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeDAO extends AbstractDAO{
    private GheDAO gheDAO = new GheDAO();
    private SuatChieuDAO suatChieuDAO = new SuatChieuDAO();
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public List<Ve> getVeByIDUser(int idUser){
        List<Ve> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select ID_HOADON from hoadon where ID_USER = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                int idHoaDon = rs.getInt("ID_HOADON");
                List<Ve> veList = getVeByIDHoaDon(idHoaDon);
                for(Ve ve : veList){
                    list.add(ve);
                }

            }
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return null;
    }
    public List<Ve> getVeByIDHoaDon(int idHoaDon){
       List<Ve> list = new ArrayList<>();
       Connection connection = null;
       PreparedStatement pstm = null;
       ResultSet rs = null;
       try {
           connection = UserDAO.getConnection();
           String sql = "select * from ve where ID_HOADON = ?";
           pstm = connection.prepareStatement(sql);
           pstm.setInt(1, idHoaDon);
           rs = pstm.executeQuery();
           while(rs.next()){
               Ve ve = new Ve();
               ve.setIdVe(rs.getInt("ID_VE"));
               ve.setGhe(gheDAO.getGheByID(rs.getInt("ID_GHE")));
               ve.setSuatChieu(suatChieuDAO.getSuatChieuByID(rs.getInt("ID_SUATCHIEU")));
               ve.setHoaDon(hoaDonDAO.getHoaDonByID(rs.getInt("ID_HOADON")));
               list.add(ve);



           }
           return list;


       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           try {
               if(connection != null){
                   connection.close();
               }
               if(pstm != null){
                   pstm.close();
               }
               if(rs != null){
                   rs.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }


       }
       return null;
   }


    public void insertVe(Ve ve){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "insert into ve(id_ghe, id_suatchieu, id_hoadon) VALUES (?, ?, ?)";

            pstm = connection.prepareStatement(sql,  Statement. RETURN_GENERATED_KEYS );
            pstm.setInt(1, ve.getGhe().getIdGhe());
            pstm.setInt(2, ve.getSuatChieu().getIdSuatChieu());
            pstm.setInt(3, ve.getHoaDon().getIdHoaDon());

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
