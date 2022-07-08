package com.example.cinema.model;

public class Rap {
    private int idRap;
    private String tenRap;
    private String diaChi;
    private String thongTin;

    public Rap() {
    }
    public Rap(String tenRap, String diaChi, String thongTin) {
        this.tenRap = tenRap;
        this.diaChi = diaChi;
        this.thongTin = thongTin;
    }
    public Rap(int idRap, String tenRap, String diaChi, String thongTin) {
        this.idRap = idRap;
        this.tenRap = tenRap;
        this.diaChi = diaChi;
        this.thongTin = thongTin;
    }

    public int getIdRap() {
        return idRap;
    }

    public void setIdRap(int idRap) {
        this.idRap = idRap;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }
}
