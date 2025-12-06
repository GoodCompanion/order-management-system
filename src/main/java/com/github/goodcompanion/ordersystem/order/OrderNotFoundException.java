package com.github.goodcompanion.ordersystem.order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Заказ с ID " + orderId + " не найден");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
