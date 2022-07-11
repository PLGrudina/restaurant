package com.company.dao;

import com.company.dto.Food;
import com.company.dto.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.dao.connection.DbConnection.getConnection;

public class FoodDao {

    private final static String TABLE = "foods";
    private final IngredientDao ingredientDao = new IngredientDao();
    private final FoodToIngredientDao foodToIngredientDao = new FoodToIngredientDao();

    public Food create(Food food) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            stmnt.execute("INSERT INTO " + TABLE + " VALUES(0,'" + food.getName() + "', " + food.getWeight() +");");
            ResultSet rs = stmnt.executeQuery("SELECT * FROM " + TABLE + " WHERE name='" + food.getName() + "';");
            Food cratedFood = rsToFood(rs).get(0);
            List<Long> ingredientsIds = food.getIngredients().stream().map(Ingredient::getId).collect(Collectors.toList());
            foodToIngredientDao.insert(cratedFood.getId(), ingredientsIds);
            return cratedFood;
        } catch (Exception e) {
            System.out.println("ingredient not created");
            throw new RuntimeException();
        }
    }

    public Food findByName(String name) {
        try (Connection connection = getConnection();
             Statement stmnt = connection.createStatement()) {
            ResultSet rs = stmnt.executeQuery("SELECT * FROM " + TABLE + " WHERE name='" + name + "';");
            Food food = rsToFood(rs).get(0);
            List<Long> ingredientIds = foodToIngredientDao.findById(food.getId());
            List<Ingredient> ingredients = ingredientIds.stream().map(ingredientDao::findById).collect(Collectors.toList());
            food.setIngredients(ingredients);
            return food;
        } catch (Exception e) {
            System.out.println("ingredient not found");
            throw new RuntimeException();
        }
    }

    private List<Food> rsToFood(ResultSet rs) {
        try {
            List<Food> foods = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int weight = rs.getInt("weight");
                foods.add(new Food(id, name, weight));
            }
            rs.close();
            return foods;
        } catch (Exception e) {
            System.out.println("can`t parse food");
            throw new RuntimeException();
        }
    }
}
