package com.github.goodcompanion.ordersystem.repository;

import com.github.goodcompanion.ordersystem.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findBymail(String email);
}
