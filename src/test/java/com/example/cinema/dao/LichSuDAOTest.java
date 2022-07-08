package com.example.cinema.dao;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class LichSuDAOTest {
    @Test
    public static void main(String[] args) {
        LichSuDAO lichSuDAO = new LichSuDAO();
        Gson gson = new Gson();
        System.out.println(gson.toJson(lichSuDAO.getLichSuByIDUser(1)));
    }
}
