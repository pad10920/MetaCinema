package com.example.cinema.mapper;

public class UserMapper {
    private int idUser;
    private String userName;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;

    public UserMapper() {
    }

    public UserMapper(int idUser, String hoTen, String diaChi, String sdt, String email) {
        this.idUser = idUser;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public UserMapper(String userName, String hoTen, String diaChi, String sdt, String email) {
        this.userName = userName;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public UserMapper(int idUser, String userName, String hoTen, String diaChi, String sdt, String email) {
        this.idUser = idUser;
        this.userName = userName;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
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


}
