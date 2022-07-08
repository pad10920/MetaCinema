package com.example.cinema.dao;

import com.example.cinema.model.SuatChieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SuatChieuDAO extends AbstractDAO{
    private PhimDAO phimDAO = new PhimDAO();
    private PhongChieuDAO phongChieuDAO = new PhongChieuDAO();
    public List<SuatChieu> findAll(){
        List<SuatChieu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from suatchieu";
            pstm = connection.prepareStatement(sql);

            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                list.add(suatChieu);
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
    public SuatChieu getSuatChieuByID(int idSuatChieu){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from suatchieu where ID_SUATCHIEU = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idSuatChieu);
            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                return suatChieu;
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
    public List<SuatChieu> getSuatChieuByDate(String date){
        List<SuatChieu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from suatchieu where NGAY_CHIEU = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, date);
            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                list.add(suatChieu);
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
    public List<SuatChieu> getSuatChieuByPhimAndDate(int idPhim, String date){
        List<SuatChieu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from suatchieu where ID_PHIM = ? and NGAY_CHIEU = ? order by THOI_GIAN_BD";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idPhim);
            pstm.setString(2, date);
            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                list.add(suatChieu);
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
    public List<SuatChieu> getSuatChieyByIDPhim(int idPhim){
        List<SuatChieu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from suatchieu where ID_PHIM = ? ";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idPhim);
            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                list.add(suatChieu);
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

    public List<SuatChieu> getSuatChieuByNgay(String ngay){
        List<SuatChieu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select *\n" +
                    "from suatchieu where NGAY_CHIEU = ? ";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, ngay);
            rs = pstm.executeQuery();
            while(rs.next()){
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setIdSuatChieu(rs.getInt("ID_SUATCHIEU"));
                suatChieu.setGiaVe(rs.getInt("GIA_VE"));
                suatChieu.setNgayChieu(rs.getDate("NGAY_CHIEU"));
                suatChieu.setThoiGianBD(rs.getTime("THOI_GIAN_BD"));
                suatChieu.setPhim(phimDAO.getPhimById(rs.getInt("ID_PHIM")));
                suatChieu.setPhongChieu(phongChieuDAO.getPhongChieuByID(rs.getInt("ID_PHONGCHIEU")));
                list.add(suatChieu);
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

}
