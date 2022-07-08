package com.example.cinema.dao;


import com.example.cinema.model.HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HoaDonDAO extends AbstractDAO{


    UserDAO userDAO = new UserDAO();

    public List<HoaDon> getHoaDonByIDUser(int idUser){
        List<HoaDon> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from hoadon where ID_USER = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(rs.getInt("ID_HOADON"));
                hoaDon.setNgayMua(rs.getDate("NGAY_MUA"));
                hoaDon.setSoLuong(rs.getInt("SO_LUONG"));
                hoaDon.setTongTien(rs.getInt("TONG_TIEN"));
                hoaDon.setUser(userDAO.getUserById(rs.getInt("ID_USER")));
                list.add(hoaDon);

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
    public HoaDon getHoaDonByID(int idHoaDon) {
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from hoadon where ID_HOADON = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idHoaDon);
            rs = pstm.executeQuery();
            while(rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(rs.getInt("ID_HOADON"));
                hoaDon.setNgayMua(rs.getDate("NGAY_MUA"));
                hoaDon.setSoLuong(rs.getInt("SO_LUONG"));
                hoaDon.setTongTien(rs.getInt("TONG_TIEN"));
                hoaDon.setUser(userDAO.getUserById(rs.getInt("ID_USER")));
                return hoaDon;

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
    public int insertHoaDon(HoaDon hoaDon){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "insert into hoadon(ngay_mua, so_luong, tong_tien, id_user)  values (?, ?, ?, ?)";

            pstm = connection.prepareStatement(sql,  Statement. RETURN_GENERATED_KEYS );
            pstm.setDate(1, hoaDon.getNgayMua());
            pstm.setInt(2, hoaDon.getSoLuong());
            pstm.setInt(3, hoaDon.getTongTien());
            pstm.setInt(4, hoaDon.getUser().getIdUser());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            while (rs.next()){
                return rs.getInt(1);
            }



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
        return 0;
    }



}
