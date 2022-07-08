package com.example.cinema.dao;

import com.example.cinema.model.Ghe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GheDAO {
    public Ghe getGheByID(int idGhe){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = AbstractDAO.getConnection();
            String sql = "select * from ghe where ID_GHE = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idGhe);
            rs = pstm.executeQuery();
            while(rs.next()){
                Ghe ghe = new Ghe();
                ghe.setIdGhe(rs.getInt("ID_GHE"));
                ghe.setGheSo(rs.getInt("GHE_SO"));
                ghe.setTrangThai(rs.getBoolean("TRANG_THAI"));
                return ghe;
            }



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
    public List<Ghe> getGheByIDSuatChieu(int idSuatChieu){
        List<Ghe> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from ghe where ID_SUATCHIEU = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idSuatChieu);
            rs = pstm.executeQuery();
            while(rs.next()){
                Ghe ghe = new Ghe();
                ghe.setIdGhe(rs.getInt("ID_GHE"));
                ghe.setGheSo(rs.getInt("GHE_SO"));
                ghe.setTrangThai(rs.getBoolean("TRANG_THAI"));
                list.add(ghe);
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
    public void updateGhe(int idGhe){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "update ghe set TRANG_THAI = true where ID_GHE = ?;";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idGhe);
            pstm.executeUpdate();

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

    }


}
