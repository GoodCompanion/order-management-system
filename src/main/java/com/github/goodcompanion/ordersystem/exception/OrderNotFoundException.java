package com.github.goodcompanion.ordersystem.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Заказ с ID " + orderId + " не найден");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
