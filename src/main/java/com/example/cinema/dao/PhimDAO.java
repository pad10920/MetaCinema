/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import com.example.cinema.model.Phim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author cuong
 */
public class PhimDAO {

    public List<Phim> findAll(){
        List<Phim> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select ID_PHIM from phim";
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                Phim phim = new Phim();
                int id = rs.getInt("ID_PHIM");
                list.add(getPhimById(id));
                
                
                
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
    public Phim getPhimById(int id){
        Phim phim = new Phim();
        
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "SELECT * FROM `phim` WHERE ID_PHIM = ?";

            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                phim.setId(rs.getInt("ID_PHIM"));
                phim.setTenPhim(rs.getString("TEN_PHIM"));
                phim.setThoiLuong(rs.getInt("THOI_LUONG"));
                phim.setMoTa(rs.getString("MO_TA"));
                phim.setQuocGia(rs.getString("QUOC_GIA"));
                phim.setAnhPhim(rs.getString("ANH_PHIM"));
                phim.setTrangThai(rs.getInt("TRANG_THAI"));
//                return phim;
                
            }
            String sql1 = "SELECT TEN_LOAI from theloai, theloaiphim, phim WHERE\n" +
                            " phim.ID_PHIM = theloaiphim.ID_PHIM\n" +
                            "AND theloaiphim.ID_THELOAI = theloai.ID_THELOAI\n" +
                            "AND phim.ID_PHIM = ?;";
            pstm = connection.prepareStatement(sql1);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            List<String> listTheLoai = new ArrayList<>();
            while(rs.next()){
                listTheLoai.add(rs.getString("TEN_LOAI"));
               
            }
            phim.setLoaiPhim(listTheLoai);
            return phim;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
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
    public List<Phim> getPhimByLoai(int loai){
        List<Phim> list = new ArrayList<>();
//        if(loai == 1){
//            list = getPhimDangChieuTheoRap(idrap);
//            return list;
//        }
//        else{
            list = findAll();
            List<Phim> listLoai = new ArrayList<>();
            for(Phim phim : list){
                if(phim.getTrangThai() == loai){
                    listLoai.add(phim);
                }
            }
            return listLoai;
//        }


    }
    public List<Phim> getPhimDangChieuTheoRap(int idRap){
        List<Phim> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select phim.ID_PHIM, TEN_PHIM, THOI_LUONG, MO_TA, QUOC_GIA, ANH_PHIM, TRANG_THAI\n" +
                    "from phim\n" +
                    "left join suatchieu s on phim.ID_PHIM = s.ID_PHIM\n" +
                    "inner join phongchieu p on s.ID_PHONGCHIEU = p.ID_PHONGCHIEU\n" +
                    "where ID_RAP = ?\n" +
                    "group by TEN_PHIM\n" +
                    "order by ID_PHIM desc\n" +
                    "\n";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idRap);
            rs = pstm.executeQuery();
            while(rs.next()){
                Phim phim = new Phim();
                int id = rs.getInt("ID_PHIM");
                list.add(getPhimById(id));
            }
            List<Phim> listtmp = getPhimByLoai(2);
            for(Phim p : listtmp){
                list.add(p);
            }
            listtmp = getPhimByLoai(3);
            for(Phim p : listtmp){
                list.add(p);
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


    
    public int getLastIDPhim(){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int lastID = 0;
        try {
            connection = UserDAO.getConnection();
            String sql = "SELECT ID_PHIM FROM `phim` order by ID_PHIM DESC LIMIT 1";
            pstm = connection.prepareStatement(sql);
            
            
            rs = pstm.executeQuery();
            while(rs.next()){
                lastID = rs.getInt("ID_PHIM");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
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
        return lastID + 1;
    }
    public void insert(Phim phim){
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "INSERT INTO `phim`(`TEN_PHIM`, `THOI_LUONG`, `MO_TA`, `QUOC_GIA`, `ANH_PHIM`, `TRANG_THAI`) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, phim.getTenPhim());
            pstm.setInt(2, phim.getThoiLuong());
            pstm.setString(3, phim.getMoTa());
            pstm.setString(4, phim.getQuocGia());
            pstm.setString(5, phim.getAnhPhim());
            pstm.setInt(6, phim.getTrangThai());
            
            pstm.executeUpdate();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
    }
//    public void update(int id, Phim phim){
//        Connection connection = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        try {
//            connection = UserDAO.getConnection();
//            String sql = "UPDATE `phim` SET `TEN_PHIM`= ?,`THOI_LUONG`= ?,`XUAT_XU`= ?,`MIEU_TA`= ?,`ANH_PHIM`= ? WHERE ID = ?";
//            pstm = connection.prepareStatement(sql);
//            pstm.setString(1, phim.getTenPhim());
//            pstm.setInt(2, phim.getThoiLuong());
//            pstm.setString(3, phim.getXuatXu());
//            pstm.setString(4, phim.getMieuTa());
//            pstm.setString(5, phim.getAnhPhim());
//            pstm.setInt(6, id);
//            pstm.executeUpdate();
//            
//            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void deleteById(int id){
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "DELETE FROM `phim` WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
    }
}
