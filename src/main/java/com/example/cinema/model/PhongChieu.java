package com.example.cinema.model;

public class PhongChieu {
    private int idPhongChieu;
    private String tenPhong;
    private int soLuongGhe;
    private Rap rap;

    public PhongChieu() {
    }

    public PhongChieu(int idPhongChieu, String tenPhong, int soLuongGhe, Rap rap) {
        this.idPhongChieu = idPhongChieu;
        this.tenPhong = tenPhong;
        this.soLuongGhe = soLuongGhe;
        this.rap = rap;
    }
    public PhongChieu(String tenPhong, int soLuongGhe, Rap rap) {
        this.tenPhong = tenPhong;
        this.soLuongGhe = soLuongGhe;
        this.rap = rap;
    }

    public int getIdPhongChieu() {
        return idPhongChieu;
    }

    public void setIdPhongChieu(int idPhongChieu) {
        this.idPhongChieu = idPhongChieu;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public Rap getRap() {
        return rap;
    }

    public void setRap(Rap rap) {
        this.rap = rap;
    }
}
