/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.model;

/**
 *
 * @author cuong
 */
public class User {
    private int idUser;
    private String userName;
    private String passWord;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;
    private String quyen;

    public User() {
    }

    public User(String userName, String passWord, String hoTen, String diaChi, String sdt, String email, String quyen) {
       
        this.userName = userName;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.quyen = quyen;
    }

    public User(int idUser, String userName, String passWord, String hoTen, String diaChi, String sdt, String email, String quyen) {
        this.idUser = idUser;
        this.userName = userName;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.quyen = quyen;
    }

    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    

    
    
}
