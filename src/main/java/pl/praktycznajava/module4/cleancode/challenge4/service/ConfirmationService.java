package pl.praktycznajava.module4.cleancode.challenge4.service;

import pl.praktycznajava.module4.cleancode.challenge4.model.Order;

public interface ConfirmationService {
    void confirm(Order order, double totalPrice);
}
