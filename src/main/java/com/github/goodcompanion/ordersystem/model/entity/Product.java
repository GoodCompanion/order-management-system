package com.github.goodcompanion.ordersystem.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String productArticle;
    @Column
    private String productName;
    @Column
    private String productDescription;
    @Column
    private String productCategory;
    @Column
    private BigDecimal productPrice;
    @Column
    private Long productQuantity;
    @Column
    private Boolean isActive;
    @Column
    private LocalDateTime createAt;

    public Product(String productArticle, String productName, String productDescription, String productCategory, BigDecimal productPrice, Long productQuantity, Boolean isActive, LocalDateTime createAt) {
        this.productArticle = productArticle;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.isActive = isActive;
        this.createAt = createAt;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String productName;
        private String productArticle;
        private String productDescription;
        private String productCategory;
        private BigDecimal productPrice;
        private Long productQuantity = 0L;
        private Boolean isActive = false;
        private LocalDateTime createAt = LocalDateTime.now();

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder productArticle(String productArticle) {
            this.productArticle = productArticle;
            return this;
        }

        public ProductBuilder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public ProductBuilder productCategory(String productCategory) {
            this.productCategory = productCategory;
            return this;
        }

        public ProductBuilder productPrice(BigDecimal productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public ProductBuilder productQuantity(Long productQuantity) {
            this.productQuantity = productQuantity;
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
            if (productName == null){
                throw new IllegalArgumentException("productName обязательное");
            }
            return new Product();
        }
    }
}
