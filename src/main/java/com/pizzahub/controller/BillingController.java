package com.pizzahub.controller;

import com.pizzahub.model.Bill;
import com.pizzahub.service.BillingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public String billingPage() {
        return "billing";
    }

    @PostMapping
    public String generateBill(
            @RequestParam String customer,
            @RequestParam double amount,
            Model model) {

        try {
            Bill bill = billingService.generateBill(customer, amount);
            model.addAttribute("bill", bill);
            model.addAttribute("success", true);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "billing";
    }
}
