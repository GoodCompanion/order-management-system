package com.github.goodcompanion.ordersystem.controller;

import com.github.goodcompanion.ordersystem.model.dto.CreateOrderRequest;
import com.github.goodcompanion.ordersystem.model.entity.Customer;
import com.github.goodcompanion.ordersystem.model.entity.Order;
import com.github.goodcompanion.ordersystem.repository.CustomerRepository;
import com.github.goodcompanion.ordersystem.repository.OrderRepository;
import jakarta.validation.Valid;
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

    @Autowired
    private CustomerRepository customerRepository;

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
    public ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        try {
            Optional<Customer> customerOptional = customerRepository.findById(request.getCustomerId());
            if (customerOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("Ошибка: Клиент с ID " + request.getCustomerId() + " не найден");
            }
            Customer customer = customerOptional.get();

            Order order = new Order();
            order.setDescription(request.getDescription());
            order.setPrice(request.getPrice());
            order.setCustomer(customer);

            Order savedOrder = orderRepository.save(order);

            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при создании заказа: " + e.getMessage());
        }
    }

    //обновить заказ
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
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
