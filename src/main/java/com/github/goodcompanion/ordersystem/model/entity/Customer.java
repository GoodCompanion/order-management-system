package com.github.goodcompanion.ordersystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private LocalDateTime registrationDate;
    @Column
    private BigDecimal balance;
    @Column
    private Long purchaseCount;

    public Customer(String name, String email, String phoneNumber, LocalDateTime registrationDate, BigDecimal balance, Long purchaseCount) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.purchaseCount = purchaseCount;
    }

    public static CustomerBuilder builder(){
        return new CustomerBuilder();
    }

    public static class CustomerBuilder{
        private String name;
        private String email;
        private String phoneNumber;
        private LocalDateTime registrationDate = LocalDateTime.now();
        private BigDecimal balance = BigDecimal.ZERO;
        private Long purchaseCount = 0L;

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

