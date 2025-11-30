package com.github.goodcompanion.ordersystem.service;

import com.github.goodcompanion.ordersystem.model.dto.CreateOrderRequest;
import com.github.goodcompanion.ordersystem.model.entity.Customer;
import com.github.goodcompanion.ordersystem.model.entity.Order;
import com.github.goodcompanion.ordersystem.repository.CustomerRepository;
import com.github.goodcompanion.ordersystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Order createOrder(CreateOrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("Клиент не найден"));

        Order order = new Order();
        order.setDescription(request.getDescription());
        order.setPrice(request.getPrice());
        order.setCustomer(customer);

        return orderRepository.save(order);
    }
}
