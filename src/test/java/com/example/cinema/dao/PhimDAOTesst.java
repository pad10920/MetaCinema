package com.example.cinema.dao;

import org.junit.jupiter.api.Test;

public class PhimDAOTesst {
    @Test

    public static void main(String[] args) {
        PhimDAO phimDAO = new PhimDAO();
        System.out.println(phimDAO.getPhimDangChieuTheoRap(2));
    }
}
