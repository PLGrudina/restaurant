package com.company.dao;

import com.company.dto.Client;

import java.sql.SQLException;

public class ClientDao {

    public Client create(String name) throws SQLException {
        DbConnection.getConnection().executeQuery("<add db query here>");
        return null;
    }

    public Client getClientById(long clientId) {
        return null;
    }

    public Client getClientByName(String name) {
        return null;
    }

    public Client update(String name) {
       return null;
    }

    public void delete(long id) {

    }
}
