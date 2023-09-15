package pl.praktycznajava.module4.cleancode.challenge5;

import lombok.AllArgsConstructor;
import pl.praktycznajava.module4.cleancode.challenge5.model.*;
import pl.praktycznajava.module4.cleancode.challenge5.service.ConfirmationService;

@AllArgsConstructor
public class Challenge5Service {

    // ---------------------------------------------------------------------------------------------------
    // Challenge 5. Zrefaktoryzuj ciała dwóch poniższych metod w taki sposób, aby były jasne i czytelne.
    //              Zwróć uwagę, aby ta metoda nie korzystała z argumentów wyjściowych.
    // --------------------------------------------------------------------------------------------

    private final ConfirmationService confirmationService;

    public Order processOrder(Order order, Product product, Rates rates) {
        double totalPrice = calculateTotalPrice(order);
        calculateDiscount(rates, product);
        return confirmationService.confirm(order, totalPrice);
    }

    void calculateDiscount(Rates rates, Product product) {
        double discountPercentage = rates.getPercentageDiscountBy(product.getType(), product.getPrice());
        Price discount = product.getPrice().getByPercentage(discountPercentage);
        product.addDiscount(discount);
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0.0;
        for (OrderItem orderItem : order.getItems()) {
            double itemPrice = orderItem.getProduct().getPrice().getValue() * orderItem.getQuantity();
            totalPrice += itemPrice;
        }
        return totalPrice;
    }
}
