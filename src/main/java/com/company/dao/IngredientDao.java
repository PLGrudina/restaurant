package com.company.dao;

import com.company.dto.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.company.dao.connection.DbConnection.getConnection;

public class IngredientDao {

    private final static String TABLE = "ingredients";

    public Ingredient create(String name) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            stmnt.execute("INSERT INTO " + TABLE + " VALUES(0,'" + name + "');");
            ResultSet rs = stmnt.executeQuery("SELECT * FROM " + TABLE + " WHERE name='" + name + "';");
            return rsToIngredient(rs).get(0);
        } catch (Exception e) {
            System.out.println("ingredient not created");
            throw new RuntimeException();
        }
    }

    public Ingredient findById(long id) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            ResultSet rs = stmnt.executeQuery("SELECT * FROM " + TABLE + " WHERE id=" + id + ";");
            return rsToIngredient(rs).get(0);
        } catch (Exception e) {
            System.out.println("ingredient not found");
            throw new RuntimeException();
        }
    }

    public void delete(long id) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            stmnt.execute("DELETE FROM " + TABLE + " WHERE id=" + id + ";");
        } catch (Exception e) {
            System.out.println("ingredient not deleted id=" + id);
        }
    }

    private List<Ingredient> rsToIngredient(ResultSet rs) {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                ingredients.add(new Ingredient(id, name));
            }
            rs.close();
            return ingredients;
        } catch (Exception e) {
            System.out.println("can`t parse ingredient");
            throw new RuntimeException();
        }
    }
}
