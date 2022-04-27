package com.company.dao;

import java.sql.*;

public class DbConnection {

    public static Statement getConnection() {
        String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
        String USER = "guest";
        String PASS = "guest123";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            return stmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
