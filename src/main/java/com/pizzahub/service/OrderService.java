package com.pizzahub.service;

import com.pizzahub.model.Order;
import com.pizzahub.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private final PizzaService pizzaService;

    public OrderService(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    public Order placeOrder(String customer, int pizzaIndex, int quantity, String offer) {
        if (customer == null || customer.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter your name.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        Pizza pizza = pizzaService.getPizza(pizzaIndex);

        double subtotal = pizza.getPrice() * quantity;
        double discount = 0.0;

        if ("SAVE20".equalsIgnoreCase(offer == null ? "" : offer.trim())) {
            discount = subtotal * 0.20;
        }

        double amountAfterDiscount = subtotal - discount;
        double gst = amountAfterDiscount * 0.05;
        double grandTotal = amountAfterDiscount + gst;

        Order order = new Order();
        order.setOrderId("ORD" + (10000 + (int) (Math.random() * 90000)));
        order.setCustomer(customer.trim());
        order.setPizza(pizza);
        order.setQuantity(quantity);
        order.setSubtotal(subtotal);
        order.setDiscount(discount);
        order.setAmountAfterDiscount(amountAfterDiscount);
        order.setGst(gst);
        order.setGrandTotal(grandTotal);

        orders.put(order.getOrderId(), order);
        return order;
    }

    public Order findOrder(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            return null;
        }
        return orders.get(orderId.trim().toUpperCase());
    }
}
