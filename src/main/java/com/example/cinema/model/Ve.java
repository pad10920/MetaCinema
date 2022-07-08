package com.example.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hoaDon"})
public class Ve {
    private int idVe;
    private Ghe ghe;
    private SuatChieu suatChieu;
    @JsonIgnore
    private HoaDon hoaDon;

    public Ve() {
    }

    public Ve(int idVe, Ghe ghe, SuatChieu suatChieu, HoaDon hoaDon) {
        this.idVe = idVe;
        this.ghe = ghe;
        this.suatChieu = suatChieu;
        this.hoaDon = hoaDon;
    }
    public Ve(Ghe ghe, SuatChieu suatChieu, HoaDon hoaDon) {

        this.ghe = ghe;
        this.suatChieu = suatChieu;
        this.hoaDon = hoaDon;
    }

    public int getIdVe() {
        return idVe;
    }

    public void setIdVe(int idVe) {
        this.idVe = idVe;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public SuatChieu getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
}
