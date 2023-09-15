package pl.praktycznajava.module4.cleancode.challenge5.service;

import pl.praktycznajava.module4.cleancode.challenge5.model.Order;

public interface ConfirmationService {
    Order confirm(Order order, double totalPrice);
}
