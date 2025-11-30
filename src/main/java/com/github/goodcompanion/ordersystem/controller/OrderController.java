package com.github.goodcompanion.ordersystem.controller;

import com.github.goodcompanion.ordersystem.model.dto.CreateOrderRequest;
import com.github.goodcompanion.ordersystem.model.entity.Order;
import com.github.goodcompanion.ordersystem.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //получить все заказы
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    //получить заказ по id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //создать новый заказ
    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        try {
            Order savedOrder = orderService.createOrder(request);
            return ResponseEntity.ok(savedOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при создании заказа: " + e.getMessage());
        }
    }

    //обновить заказ
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        try {
            Order updateOrder = orderService.updateOrder(id, orderDetails);
            return ResponseEntity.ok(updateOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //удалить заказ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderService.gerOrderByStatus(status);
    }
}
