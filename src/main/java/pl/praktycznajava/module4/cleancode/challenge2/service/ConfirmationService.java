package pl.praktycznajava.module4.cleancode.challenge2.service;

import pl.praktycznajava.module4.cleancode.challenge2.model.Order;

public interface ConfirmationService {
    void confirm(Order order, double totalPrice);
}
