package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pizza.PizzaNotFoundException;
import org.example.pizza.PizzaService;
import org.example.pizza.model.Order;
import org.example.pizza.model.Pizza;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        PizzaService pizzaService = new PizzaService();
        List<Pizza> pizzaList = pizzaService.getAvailablePizzas();

        System.out.println("Lista dospnych pizz: ");
        for (Pizza pizza: pizzaList){
            System.out.println(pizza);
        }

        try {
            Order order1 = pizzaService.makeOrder(pizzaList.get(0));
            Order order2 = pizzaService.makeOrder(pizzaList.get(1));
            Order order3 = pizzaService.makeOrder(pizzaList.get(2));

            pizzaService.makeOrder(new Pizza("Nie istniejąca", 40.0));

            System.out.println(order1);
            System.out.println(order2);
            System.out.println(order3);
        }
        catch (PizzaNotFoundException e){
            logger.error("PizzaNotFoundException");
            e.printStackTrace();
        }

    }
}
