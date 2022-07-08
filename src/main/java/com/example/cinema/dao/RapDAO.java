package com.example.cinema.dao;

import com.example.cinema.model.Rap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RapDAO extends AbstractDAO{
    public List<Rap> findAll(){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Rap> list = new ArrayList<>();
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from rap";
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Rap rap = new Rap();
                rap.setIdRap(rs.getInt("ID_RAP"));
                rap.setTenRap(rs.getString("TEN_RAP"));
                rap.setDiaChi(rs.getString("DIA_CHI"));
                rap.setThongTin(rs.getString("THONG_TIN"));
                list.add(rap);
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

//select * from suatchieu where ID_PHONGCHIEU in (select phongchieu.ID_PHONGCHIEU from phongchieu where ID_RAP = 2);
    public Rap getRapByID(int id){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from rap where ID_RAP = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                Rap rap = new Rap();
                rap.setIdRap(rs.getInt("ID_RAP"));
                rap.setTenRap(rs.getString("TEN_RAP"));
                rap.setDiaChi(rs.getString("DIA_CHI"));
                rap.setThongTin(rs.getString("THONG_TIN"));
                return rap;
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
}
