/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema.dao;

/**
 *
 * @author cuong
 */

import java.sql.Connection;
import java.sql.DriverManager;
public class AbstractDAO {
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ltweb", "root", "109.2.duc");
        } catch (Exception e) {
            return null;
        }
    }
}
