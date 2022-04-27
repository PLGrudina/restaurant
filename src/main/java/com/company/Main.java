package com.company;


import com.company.dao.ClientDao;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
//  before starting restaurant workflow you should create ingredients, food and menu
//	workflow should be implemented in loop/stream for at least 10 clients
//        1. Create client
//        2. Print menu
//        3. Add new order
//  after processing 10 clients print full restaurant order book

        ClientDao clientDao = new ClientDao();
        clientDao.create("Vasya");
    }
}
