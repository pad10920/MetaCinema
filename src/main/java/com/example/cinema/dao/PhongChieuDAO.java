package com.example.cinema.dao;

import com.example.cinema.model.PhongChieu;
import com.example.cinema.model.Rap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhongChieuDAO extends AbstractDAO{
    private RapDAO rapDAO = new RapDAO();
    public PhongChieu getPhongChieuByID(int id){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from phongchieu where ID_PHONGCHIEU = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                PhongChieu phongChieu = new PhongChieu();
                phongChieu.setIdPhongChieu(rs.getInt("ID_PHONGCHIEU"));
                phongChieu.setTenPhong(rs.getString("TEN_PHONG"));
                phongChieu.setSoLuongGhe(rs.getInt("SO_LUONG_GHE"));
                Rap rap = rapDAO.getRapByID(rs.getInt("ID_RAP"));
                phongChieu.setRap(rap);
                return phongChieu;
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
