package com.github.goodcompanion.ordersystem.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerId) {
        super("Клиент с ID " + customerId + " не найден");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
