package com.github.goodcompanion.ordersystem.controller;

import com.github.goodcompanion.ordersystem.model.entity.Order;
import com.github.goodcompanion.ordersystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    //получить все заказы
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //получить заказ по id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //создать новый заказ
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    //обновить заказ
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(Long id, Order orderDetails) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setDescription(orderDetails.getDescription());
            order.setPrice(orderDetails.getPrice());
            order.setStatus(orderDetails.getStatus());
            order.setCustomer(orderDetails.getCustomer());

            Order updateOrder = orderRepository.save(order);
            return ResponseEntity.ok(updateOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //удалить заказ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderRepository.findByStatus(status);
    }
}
