package pl.praktycznajava.module4.cleancode.challenge2.service;

import pl.praktycznajava.module4.cleancode.challenge2.model.Notification;
import pl.praktycznajava.module4.cleancode.challenge2.model.Order;
import pl.praktycznajava.module4.cleancode.challenge2.model.ShipmentStatus;

public interface NotificationSender {
    void sendNotification(Order order, Notification notification);

    void sendNotification(Order order, Notification orderSent, ShipmentStatus shipmentStatus);
}
