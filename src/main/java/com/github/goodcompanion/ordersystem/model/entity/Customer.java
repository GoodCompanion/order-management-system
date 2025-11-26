package com.github.goodcompanion.ordersystem.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Класс, который отображается на таблицу в базе данных
 * Каждый объект это одна строка в таблице
 * Использует JPA аннотации для настройки
 *
 * @Entity - "это таблица в БД"
 * @Id - "это главный идентификатор"
 * @GeneratedValue - "генерируй ID автоматически"
 * @Column - "настройки для колонки"
 */
@Entity
public class Customer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column
    private String email;
    @Getter
    @Setter
    @Column
    private String phoneNumber;
    @Getter
    @Setter
    @Column
    private LocalDateTime registrationDate;
    @Getter
    @Setter
    @Column (columnDefinition = "0.0")
    private BigDecimal balance;
    @Getter
    @Setter
    @Column (columnDefinition = "0")
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

    public static class CustomerBuilder{
        private String name;
        private String email;
        private String phoneNumber;
        private LocalDateTime registrationDate;
        private BigDecimal balance;
        private Long purchaseCount;

        public CustomerBuilder name(String name){
            this.name = name;
            return this;
        }

        public CustomerBuilder email(String email){
            this.email = email;
            return this;
        }

        public CustomerBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder registrationDate(LocalDateTime registrationDate){
            this.registrationDate = registrationDate;
            return this;
        }

        public CustomerBuilder balance(BigDecimal balance){
            this.balance = balance;
            return this;
        }

        public CustomerBuilder purchaseCount(Long purchaseCount){
            this.purchaseCount = purchaseCount;
            return this;
        }

        public Customer build(){
            if (name == null){
                throw new IllegalArgumentException("Name is required");
            }
            return new Customer(name, email, phoneNumber, registrationDate, balance, purchaseCount);
        }
    }
}

