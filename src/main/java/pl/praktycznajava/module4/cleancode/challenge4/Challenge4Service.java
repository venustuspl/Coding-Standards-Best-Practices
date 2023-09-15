package pl.praktycznajava.module4.cleancode.challenge4;

import lombok.AllArgsConstructor;
import pl.praktycznajava.module4.cleancode.challenge4.model.Order;
import pl.praktycznajava.module4.cleancode.challenge4.model.OrderItem;
import pl.praktycznajava.module4.cleancode.challenge4.service.ConfirmationService;

@AllArgsConstructor
public class Challenge4Service {

    // ---------------------------------------------------------------------------------------------
    // Challenge 4. Zrefaktoryzuj ciało poniższej metody w taki sposób, aby była jasna i czytelna.
    //              Zwróć uwagę, aby ta metoda była na jednym poziomie abstrakcji.
    // --------------------------------------------------------------------------------------

    private final ConfirmationService confirmationService;

    private void processOrder(Order order, double discountPercentage) {
        double totalPrice = calculateTotalPrice(order);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        double discountAmount = totalPrice * (discountPercentage / 100);
        totalPrice -= discountAmount;
        updateInventory(order);
        confirmationService.confirm(order, totalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0.0;
        for (OrderItem orderItem : order.getItems()) {
            double itemPrice = orderItem.getProduct().getPrice() * orderItem.getQuantity();
            totalPrice += itemPrice;
        }
        return totalPrice;
    }

    private void updateInventory(Order order) {
        for (OrderItem orderItem : order.getItems()) {

            int remainingQuantity = orderItem.getProduct().getStockQuantity() - orderItem.getQuantity();
            orderItem.getProduct().setStockQuantity(remainingQuantity);
        }
    }

}
