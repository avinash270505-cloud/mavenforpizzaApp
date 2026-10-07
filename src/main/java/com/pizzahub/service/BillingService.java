package com.pizzahub.service;

import com.pizzahub.model.Bill;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BillingService {

    public Bill generateBill(String customer, double amount) {
        if (customer == null || customer.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter the customer name.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Please enter a valid order amount.");
        }

        double gst = amount * 0.05;

        Bill bill = new Bill();
        bill.setBillNo("BILL" + ThreadLocalRandom.current().nextInt(1000, 10000));
        bill.setCustomer(customer.trim());
        bill.setSubtotal(amount);
        bill.setGst(gst);
        bill.setTotal(amount + gst);

        return bill;
    }
}
