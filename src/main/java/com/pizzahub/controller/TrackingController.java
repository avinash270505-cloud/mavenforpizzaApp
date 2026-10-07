package com.pizzahub.controller;

import com.pizzahub.model.Order;
import com.pizzahub.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/track")
public class TrackingController {

    private final OrderService orderService;

    public TrackingController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String trackingPage() {
        return "track";
    }

    @PostMapping
    public String trackOrder(@RequestParam String orderId, Model model) {
        String id = orderId == null ? "" : orderId.trim().toUpperCase();

        if (id.isEmpty()) {
            model.addAttribute("error", "Please enter your Order ID.");
            return "track";
        }

        if (!id.startsWith("ORD")) {
            model.addAttribute("error", "Invalid Order ID. Example: ORD12345");
            return "track";
        }

        Order order = orderService.findOrder(id);

        if (order == null) {
            model.addAttribute("error", "Order not found. Please place an order first and use its Order ID.");
            return "track";
        }

        String[] statuses = {
            "📥 Order Received",
            "👨‍🍳 Preparing Your Pizza",
            "🔥 Baking Pizza",
            "🛵 Out for Delivery",
            "✅ Delivered"
        };

        int[] progress = {20, 40, 60, 85, 100};
        String[] eta = {
            "35-40 minutes",
            "25-30 minutes",
            "15-20 minutes",
            "5-10 minutes",
            "Delivered Successfully"
        };

        int index = ThreadLocalRandom.current().nextInt(statuses.length);

        model.addAttribute("order", order);
        model.addAttribute("currentStatus", statuses[index]);
        model.addAttribute("currentProgress", progress[index]);
        model.addAttribute("eta", eta[index]);

        return "track";
    }
}
