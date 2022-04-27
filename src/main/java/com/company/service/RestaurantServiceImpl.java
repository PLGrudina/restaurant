package com.company.service;

import com.company.dto.Food;
import com.company.dto.Ingredients;
import com.company.dto.Order;
import com.company.dto.OrderBook;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public void createIngredient(String name) {

    }

    @Override
    public void createFood(String name, int weight, Ingredients... ingredients) {

    }

    @Override
    public List<Food> getMenu() {
        return null;
    }

    @Override
    public void createOrder(long clientId, List<Long> foodIds) {

    }

    @Override
    public List<Order> getOrdersByClient(long clientId) {
        return null;
    }

    @Override
    public OrderBook getFullOrderBook() {
        return null;
    }
}
