package com.pizzahub.model;

public class Pizza {

    private final String name;
    private final String description;
    private final double price;
    private final String emoji;

    public Pizza(String name, String description, double price, String emoji) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.emoji = emoji;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getEmoji() {
        return emoji;
    }
}
