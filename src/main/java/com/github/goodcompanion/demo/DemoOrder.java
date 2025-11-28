package com.github.goodcompanion.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "demo_order")
public class DemoOrder {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "customer")
    private DemoCustomer customer;

    public DemoOrder() {
    }

    public DemoOrder(Long id, String description, BigDecimal price, LocalDateTime createdAt, DemoCustomer customer) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public DemoCustomer getCustomer() {
        return customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCustomer(DemoCustomer customer) {
        this.customer = customer;
    }
}
