package com.example.cinema.dao;

import org.junit.jupiter.api.Test;

public class UserDAOTest {
    @Test
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
//        userDAO.updatePassWord(1,"a");
        System.out.println(userDAO.checkExitsPasswordByUser(1,"af"));
    }
}
