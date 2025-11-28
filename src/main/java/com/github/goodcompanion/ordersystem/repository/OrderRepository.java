package com.github.goodcompanion.ordersystem.repository;

import com.github.goodcompanion.ordersystem.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
}
