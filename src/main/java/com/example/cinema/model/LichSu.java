package com.example.cinema.model;

public class LichSu {
    private String tenPhim;

    private String ngayMua;
    private int giaVe;
    private int soGhe;

    public LichSu() {
    }

    public LichSu(String tenPhim, String ngayMua, int giaVe, int soGhe) {
        this.tenPhim = tenPhim;
        this.ngayMua = ngayMua;
        this.giaVe = giaVe;
        this.soGhe = soGhe;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
}
