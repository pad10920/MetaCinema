package com.example.cinema.model;

import java.sql.Date;
import java.sql.Time;


public class SuatChieu {
    private int idSuatChieu;
    private int giaVe;

    private Date ngayChieu;
    private Time thoiGianBD;
    private Phim phim;
    private PhongChieu phongChieu;

    public SuatChieu() {
    }

    public SuatChieu(int idSuatChieu, int giaVe, Date ngayChieu, Time thoiGianBD, Phim phim, PhongChieu phongChieu) {
        this.idSuatChieu = idSuatChieu;
        this.giaVe = giaVe;
        this.ngayChieu = ngayChieu;
        this.thoiGianBD = thoiGianBD;
        this.phim = phim;
        this.phongChieu = phongChieu;
    }

    public SuatChieu(int giaVe, Date ngayChieu, Time thoiGianBD, Phim phim, PhongChieu phongChieu) {
        this.giaVe = giaVe;
        this.ngayChieu = ngayChieu;
        this.thoiGianBD = thoiGianBD;
        this.phim = phim;
        this.phongChieu = phongChieu;
    }

    public int getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(int idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(Time thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }
}
