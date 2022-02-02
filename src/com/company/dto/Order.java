package com.company.dto;

import java.sql.Timestamp;
import java.util.List;

public class Order {

    private long id;
    private long clientId;
    private List<Food> foods;
    private Timestamp timestamp;
}
