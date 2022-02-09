package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class Food {

    private long id;
    private String name;
    private int weight;
    private List<Ingredients> ingredients;
}
