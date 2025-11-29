package com.github.goodcompanion.ordersystem.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreateOrderRequest {

    @NotNull(message = "Описание заказа обязательное")
    private String description;

    @NotNull(message = "Цена обязательная")
    @Positive(message = "Цена должна быть положительной")
    private BigDecimal price;

    @NotNull(message = "ID Клиента обязателен")
    private Long customerId;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(String description, BigDecimal price, Long customerId) {
        this.description = description;
        this.price = price;
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
