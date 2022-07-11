package com.company;

import com.company.dao.FoodDao;
import com.company.dao.IngredientDao;
import com.company.dto.Food;
import com.company.dto.Ingredient;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        ClientDao clientDao = new ClientDao();
//        Client cl = clientDao.create("VASYA");
//        System.out.println("client created " + cl);
//        clientDao.delete(cl.getId());
//        System.out.println("and than client deleted " + cl);
        IngredientDao ingredientDao = new IngredientDao();
        Ingredient carrot = ingredientDao.create("carrot");
        Ingredient onion = ingredientDao.create("onion");
        Ingredient cucumber = ingredientDao.create("cucumber");

        Food uglyDinner = new Food(1L, "uglyDinner", 300, Arrays.asList(carrot, onion, cucumber));
        FoodDao foodDao = new FoodDao();
        foodDao.create(uglyDinner);

//      At this point you should receive Food from database with real id`s
        Food fromDbFood = foodDao.findByName("uglyDinner");
        System.out.println(fromDbFood);
    }
}
