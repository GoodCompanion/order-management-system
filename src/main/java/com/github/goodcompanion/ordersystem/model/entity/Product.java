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
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String article;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private BigDecimal price;
    @Column
    private long stockQuantity;
    @Column
    private boolean isActive;
    @Column
    private LocalDateTime createdAt;

    public Product(String name, String article, String description, String category, BigDecimal price, long stockQuantity, boolean isActive, LocalDateTime createdAt) {
        this.name = name;
        this.article = article;
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
        private String article;
        private String description;
        private String category;
        private BigDecimal price;
        private long stockQuantity = 0L;
        private boolean isActive = true;
        private LocalDateTime createdAt = LocalDateTime.now();

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder article(String article) {
            this.article = article;
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
            if (name == null || price == null || article == null) {
                throw new IllegalArgumentException("productName обязательное");
            }
            return new Product(name, article, description, category, price, stockQuantity, isActive, createdAt);
        }
    }
}
