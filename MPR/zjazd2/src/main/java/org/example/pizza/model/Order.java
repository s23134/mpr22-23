package org.example.pizza.model;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@ToString
public class Order {
    private int orderNumber;
    private Pizza OrderedPizza;
    private Double price;

}
