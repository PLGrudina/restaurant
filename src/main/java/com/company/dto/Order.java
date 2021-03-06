package com.company.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Order {

    private long id;
    private long clientId;
    private List<Food> foods;
    private Timestamp timestamp;
}
