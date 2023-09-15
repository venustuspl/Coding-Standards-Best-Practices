package pl.praktycznajava.module4.cleancode.challenge3;

import pl.praktycznajava.module4.cleancode.challenge3.model.Order;
import pl.praktycznajava.module4.cleancode.challenge3.model.OrderItem;
import pl.praktycznajava.module4.cleancode.challenge3.model.Product;

import java.math.BigDecimal;

public class Challenge3Service {

    // -----------------------------------------------------------------------------------------------------
    // Challenge 3. Zrefaktoryzuj ciało poniższej metody w taki sposób, aby była jasna i czytelna.
    //              Zwróć uwagę na ilość wcięć. Napisz kod w taki sposób, aby można było usunąć komentarze.
    // -----------------------------------------------------------------------------------------------------

    public double calculateBonus(Order order) {
        double bonus;
        if(order.getTotalAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            double expensiveProductsSum = 0.0;

            // sumowanie cen produktów, których cena jest większa niż 100
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                if(product.getPrice() > 100) {
                    expensiveProductsSum += product.getPrice();
                }
            }
            // następnie obliczenie bonusu stanowiącego 20% tej wyliczonej sumy
            bonus = expensiveProductsSum * 0.2;
        } else {
            double expensiveProductsSum = 0.0;

            // sumowanie cen produktów, których cena jest większa niż 100
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                if(product.getPrice() > 50) {
                    expensiveProductsSum += product.getPrice();
                }
            }
            // następnie obliczenie bonusu stanowiącego 10% tej wyliczonej sumy
            bonus = expensiveProductsSum * 0.1;
        }
        return bonus;
    }

}
