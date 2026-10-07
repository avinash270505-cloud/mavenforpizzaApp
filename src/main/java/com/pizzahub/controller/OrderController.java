package com.pizzahub.controller;

import com.pizzahub.model.Order;
import com.pizzahub.service.OrderService;
import com.pizzahub.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final PizzaService pizzaService;

    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String orderPage(Model model) {
        model.addAttribute("pizzas", pizzaService.getPizzas());
        return "order";
    }

    @PostMapping
    public String placeOrder(
            @RequestParam String customer,
            @RequestParam int pizzaIndex,
            @RequestParam int quantity,
            @RequestParam(required = false, defaultValue = "") String offer,
            Model model) {

        try {
            Order order = orderService.placeOrder(customer, pizzaIndex, quantity, offer);
            model.addAttribute("order", order);
            model.addAttribute("success", true);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("pizzas", pizzaService.getPizzas());
        return "order";
    }
}
