package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Food {

    private long id;
    private String name;
    private int weight;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Food (long id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
}
