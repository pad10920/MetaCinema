package com.example.cinema.model;

public class Ghe {
    private int idGhe;
    private int gheSo;
    private boolean trangThai;

    public Ghe() {
    }

    public Ghe(int idGhe, int gheSo, boolean trangThai) {
        this.idGhe = idGhe;
        this.gheSo = gheSo;
        this.trangThai = trangThai;
    }

    public Ghe(int gheSo, boolean trangThai) {
        this.gheSo = gheSo;
        this.trangThai = trangThai;
    }

    public int getIdGhe() {
        return idGhe;
    }

    public void setIdGhe(int idGhe) {
        this.idGhe = idGhe;
    }

    public int getGheSo() {
        return gheSo;
    }

    public void setGheSo(int gheSo) {
        this.gheSo = gheSo;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
