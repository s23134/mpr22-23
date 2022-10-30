package org.example.pizza;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pizza.model.Order;
import org.example.pizza.model.Pizza;

import java.util.List;

@NoArgsConstructor
public class PizzaService {

    private List<Pizza> pizzaList = List.of(
      (new Pizza("Margarita", 40.0)),
        (new Pizza("Fungi", 43.5)),
        (new Pizza("Hawajska", 45.5)),
        (new Pizza("Góralska", 48.5)),
        (new Pizza("Szefa", 55.0)));

    private int currentOrderNumber = 1;
    private static final Logger logger = LogManager.getLogger(PizzaService.class);

    public Order makeOrder(Pizza pizza){
        logger.info("makeOrder( argument: " + pizza + " )" );
        if (!pizzaList.contains(pizza)){
            throw new PizzaNotFoundException("Nie ma takiej pizzy w menu.");
        }

        Order order = new Order(currentOrderNumber, pizza, pizza.getPrice());
        currentOrderNumber ++;

        return order;
    }

    public List<Pizza> getAvailablePizzas(){
        logger.info("getAvailablePizzas()");
        return pizzaList;
    }

}
