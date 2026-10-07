package com.pizzahub.controller;

import com.pizzahub.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PizzaService pizzaService;

    public HomeController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pizzas", pizzaService.getPizzas());
        return "index";
    }
}
