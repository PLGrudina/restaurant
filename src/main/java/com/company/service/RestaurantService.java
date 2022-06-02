package com.company.service;

import com.company.dto.Food;
import com.company.dto.Ingredients;
import com.company.dto.Order;
import com.company.dto.OrderBook;

import java.util.List;

public interface RestaurantService {

    void createIngredient(String name);
    void createFood(String name, int weight, Ingredients ... ingredients);
    List<Food> getMenu();
    void createOrder(long clientId, List<Long> foodIds);
    List<Order> getOrdersByClient(long clientId);
    OrderBook getFullOrderBook();
}
