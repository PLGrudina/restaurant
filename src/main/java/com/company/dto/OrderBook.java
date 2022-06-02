package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class OrderBook {

    private Map<Long, List<Order>> clientsOrders;
}
