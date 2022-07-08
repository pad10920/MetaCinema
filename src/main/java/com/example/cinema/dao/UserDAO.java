/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

import com.example.cinema.dto.UserDTO;
import com.example.cinema.mapper.UserMapper;
import com.example.cinema.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author cuong
 */
public class UserDAO extends AbstractDAO{

    private UserDTO userDTO = new UserDTO();
    public UserDAO() {
    }

    
    public User getUser(String userName, String passWord){
        User user = new User();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from user where USERNAME = ? AND PASSWORD = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, userName);
            pstm.setString(2, passWord);
            rs = pstm.executeQuery();
            while(rs.next()){
                user.setIdUser(rs.getInt("ID_USER"));
                user.setUserName(rs.getString("USERNAME"));
                user.setPassWord(rs.getString("PASSWORD"));
                user.setHoTen(rs.getString("HO_TEN"));
                user.setDiaChi(rs.getString("DIA_CHI"));
                user.setSdt(rs.getString("SDT"));
                user.setEmail(rs.getString("EMAIL"));
                user.setQuyen(rs.getString("QUYEN"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    

    }
    public UserMapper getUserById(int id){
        User user = new User();
        
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from user where ID_USER = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                user.setIdUser(rs.getInt("ID_USER"));
                user.setUserName(rs.getString("USERNAME"));
                user.setPassWord(rs.getString("PASSWORD"));
                user.setHoTen(rs.getString("HO_TEN"));
                user.setDiaChi(rs.getString("DIA_CHI"));
                user.setSdt(rs.getString("SDT"));
                user.setEmail(rs.getString("EMAIL"));
                user.setQuyen(rs.getString("QUYEN"));
                return userDTO.chuyenUser(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(connection!= null){
                    connection.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public void insert(User user){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "INSERT INTO `user`(`USERNAME`, `PASSWORD`, `HO_TEN`, `DIA_CHI`, `SDT`, `EMAIL`, `QUYEN`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUserName());
            pstm.setString(2, user.getPassWord());
            pstm.setString(3, user.getHoTen());
            pstm.setString(4, user.getDiaChi());
            pstm.setString(5, user.getSdt());
            pstm.setString(6, user.getEmail());
            pstm.setString(7, "USER");

            pstm.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!= null){
                    connection.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
       
    }
    public int checkExitsPasswordByUser(int idUser, String passWord){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select exists(select * from user where ID_USER = ? and PASSWORD = ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idUser);
            pstm.setString(2, passWord);
            rs = pstm.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!= null){
                    connection.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }
    public void updatePassWord(int idUser, String passWord){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "UPDATE user SET PASSWORD = ? where ID_USER = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, passWord);
            pstm.setInt(2, idUser);
            pstm.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!= null){
                    connection.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void update(UserMapper user){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "UPDATE `user` SET `HO_TEN`=?,`DIA_CHI`=?,`SDT`=?,`EMAIL`=? WHERE ID_USER = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getHoTen());
            pstm.setString(2, user.getDiaChi());
            pstm.setString(3, user.getSdt());
            pstm.setString(4, user.getEmail());
            pstm.setInt(5, user.getIdUser());

            pstm.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!= null){
                    connection.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public boolean checkExistsUser(String userName){
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = UserDAO.getConnection();
            String sql = "select * from user where USERNAME = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, userName);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
