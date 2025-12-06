package com.github.goodcompanion.ordersystem.order;

import com.github.goodcompanion.ordersystem.customer.Customer;
import jakarta.persistence.*;
import org.antlr.v4.runtime.atn.SemanticContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal price = BigDecimal.ZERO;

    @Column(nullable = false)
    private String status = "PENDING";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(String description, BigDecimal price, String status, LocalDateTime createdAt, Customer customer) {
        this.description = description;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.customer = customer;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private String description;
        private BigDecimal price = BigDecimal.ZERO;
        private String status = "PENDING";
        private LocalDateTime createdAt = LocalDateTime.now();
        private Customer customer;

        public OrderBuilder description(String description) {
            this.description = description;
            return this;
        }

        public OrderBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderBuilder status(String status) {
            this.status = status;
            return this;
        }

        public OrderBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public OrderBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Order build() {
            if (description == null) {
                throw new IllegalArgumentException("Description обязательное");
            }
            return new Order(description, price, status, createdAt, customer);
        }
    }

    public String getStatus() {
        return status;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
