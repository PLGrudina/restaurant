package com.company.dao;

import com.company.dto.Food;
import com.company.dto.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.company.dao.connection.DbConnection.getConnection;

public class FoodToIngredientDao {

    private final static String TABLE = "foodToIngredient";

    public void insert(long foodId, List<Long> ingredients) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            ingredients.forEach(ingredientId ->
            {
                try {
                    stmnt.execute("INSERT INTO " + TABLE + " VALUES(" + foodId + "," + ingredientId + ");");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            System.out.println("food to ingredients relation not created");
            throw new RuntimeException();
        }
    }

    public List<Long> findById(long food_id) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            ResultSet rs = stmnt.executeQuery("SELECT * FROM " + TABLE + " WHERE food_id=" + food_id + ";");
            return rsToIds(rs);
        } catch (Exception e) {
            System.out.println("ingredient not found");
            throw new RuntimeException();
        }
    }

    private List<Long> rsToIds(ResultSet rs) {
        try {
            List<Long> ids = new ArrayList<>();
            while (rs.next()) {
                ids.add(rs.getLong("ingredient_id"));
            }
            rs.close();
            return ids;
        } catch (Exception e) {
            System.out.println("can`t parse ids");
            throw new RuntimeException();
        }
    }
}
