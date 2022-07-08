package com.example.cinema.dao;

import com.example.cinema.model.SuatChieu;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class SuatChieuDAOTest {
    @Test
    public static void main(String[] args) {
        Gson gson = new Gson();
        SuatChieuDAO suatChieuDAO = new SuatChieuDAO();
        System.out.println(gson.toJson(suatChieuDAO.getSuatChieuByNgay("2022-05-23")));
    }
}
