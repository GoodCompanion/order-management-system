package com.github.goodcompanion.ordersystem.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Класс, который отображается на таблицу в базе данных
 * Это как паспорт клиента
 * Каждый объект это одна строка в таблице
 * Использует JPA аннотации для настройки
 *
 * @Entity - "это таблица в БД"
 * @Id - "это главный идентификатор"
 * @GeneratedValue - "генерируй ID автоматически"
 * @Column - "настройки для колонки"
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @Column(name = "balance", precision = 10, scale = 2)
    private BigDecimal balance;
    @Column(name = "purchase_count")
    private Long purchaseCount;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, LocalDateTime registrationDate, BigDecimal balance, Long purchaseCount) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.purchaseCount = purchaseCount;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {
        private String name;
        private String email;
        private String phoneNumber;
        private LocalDateTime registrationDate = LocalDateTime.now();
        private BigDecimal balance = BigDecimal.ZERO;
        private Long purchaseCount = 0L;

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder registrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public CustomerBuilder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public CustomerBuilder purchaseCount(Long purchaseCount) {
            this.purchaseCount = purchaseCount;
            return this;
        }

        public Customer build() {
            if (name == null) {
                throw new IllegalArgumentException("Name обязательное");
            }
            return new Customer(name, email, phoneNumber, registrationDate, balance, purchaseCount);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Long purchaseCount) {
        this.purchaseCount = purchaseCount;
    }
}

