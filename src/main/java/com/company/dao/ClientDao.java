package com.company.dao;

import com.company.dto.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.company.dao.connection.DbConnection.getConnection;

public class ClientDao {

    private final static String TABLE = "clients";

    public Client create(String name) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            stmnt.execute("INSERT INTO " + TABLE + " VALUES(0,'" + name + "');");
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM " + TABLE + " WHERE name='" + name + "';");
            return rsToClient(rs).get(0);
        } catch (Exception e) {
            System.out.println("client not created");
            throw new RuntimeException();
        }
    }

    public void delete(long id) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            stmnt.execute("DELETE FROM " + TABLE + " WHERE id=" + id + ";");
        } catch (Exception e) {
            System.out.println("client not deleted id=" + id);
        }
    }

    private List<Client> rsToClient(ResultSet rs) {
        try {
            List<Client> clients = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                clients.add(new Client(id, name));
            }
            rs.close();
            return clients;
        } catch (Exception e) {
            System.out.println("can`t parse client");
            throw new RuntimeException();
        }
    }
}
