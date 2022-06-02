package com.company;


import com.company.dao.ClientDao;
import com.company.dto.Client;

public class Main {

    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();
        Client cl = clientDao.create("VASYA");
        System.out.println("client created " + cl);
        clientDao.delete(cl.getId());
        System.out.println("and than client deleted " + cl);
//  before starting restaurant workflow you should create ingredients, food and menu
//	workflow should be implemented in loop/stream for at least 10 clients
//        1. Create client
//        2. Print menu
//        3. Add new order
//  after processing 10 clients print full restaurant order book

    }
}
