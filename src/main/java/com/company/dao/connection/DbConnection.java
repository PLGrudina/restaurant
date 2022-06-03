package com.company.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private final static String URL = "jdbc:mysql://localhost/restaurant?user=root&password=niger182&serverTimezone=UTC&useSSL=false";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL);
        } catch (Exception ex) {
            System.out.println("DB connection failed");
        }
        return null;
    }
}
