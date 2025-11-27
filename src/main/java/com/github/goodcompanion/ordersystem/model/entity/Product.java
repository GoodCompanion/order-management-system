package com.github.goodcompanion.ordersystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "name", nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sku", unique = true, nullable = false, length = 50)
    private String sku;
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "category", nullable = false, length = 100)
    private String category;
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "stock_quantity")
    private Long stockQuantity;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Product(String name, String sku, String description, String category, BigDecimal price, Long stockQuantity, boolean isActive, LocalDateTime createdAt) {
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String name;
        private String sku;
        private String description;
        private String category;
        private BigDecimal price;
        private Long stockQuantity = 0L;
        private Boolean isActive = true;
        private LocalDateTime createdAt = LocalDateTime.now();

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder stockQuantity(Long stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public ProductBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ProductBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Product build() {
            if (name == null) {
                throw new IllegalArgumentException("name обязательное");
            } else if (sku == null) {
                throw new IllegalArgumentException("sku обязательное");
            } else if (category == null) {
                throw new IllegalArgumentException("category обязательное");
            } else if (price == null) {
                throw new IllegalArgumentException("price обязательно");
            }
            return new Product(name, sku, description, category, price, stockQuantity, isActive, createdAt);
        }
    }
}
