package com.pizzahub.service;

import com.pizzahub.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final List<Pizza> pizzas = List.of(
        new Pizza("Margherita", "Classic Cheese Pizza", 250.00, "🍕"),
        new Pizza("Veggie Delight", "Fresh Vegetables & Cheese", 300.00, "🍕🌽"),
        new Pizza("Pepperoni", "Loaded Pepperoni Pizza", 350.00, "🍕🥩"),
        new Pizza("Farmhouse", "Mushroom & Fresh Toppings", 400.00, "🍕🍄")
    );

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Pizza getPizza(int index) {
        if (index < 0 || index >= pizzas.size()) {
            throw new IllegalArgumentException("Invalid pizza selection.");
        }
        return pizzas.get(index);
    }
}
