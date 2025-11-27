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
    @Column
    private String article;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private BigDecimal productPrice;
    @Column
    private Long productQuantity;
    @Column
    private Boolean isActive;
    @Column
    private LocalDateTime createAt;

    public Product(String name, String article, String description, String category, BigDecimal price, Long stockQuantity, Boolean isActive, LocalDateTime createAt) {
        this.name = name;
        this.article = article;
        this.description = description;
        this.category = category;
        this.productPrice = price;
        this.productQuantity = stockQuantity;
        this.isActive = isActive;
        this.createAt = createAt;
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
        private Long stockQuantity = 0L;
        private Boolean isActive = false;
        private LocalDateTime createAt = LocalDateTime.now();

        public ProductBuilder productName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder productArticle(String article) {
            this.article = article;
            return this;
        }

        public ProductBuilder productDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder productCategory(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder productPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder productQuantity(Long stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public ProductBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ProductBuilder createAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }
        public Product build(){
            if (name == null){
                throw new IllegalArgumentException("productName обязательное");
            }
            return new Product(name, article, description, category, price, stockQuantity, isActive, createAt);
        }
    }
}
