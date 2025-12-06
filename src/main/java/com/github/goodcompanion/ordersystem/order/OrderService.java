package com.github.goodcompanion.ordersystem.order;

import com.github.goodcompanion.ordersystem.customer.CustomerNotFoundException;
import com.github.goodcompanion.ordersystem.customer.Customer;
import com.github.goodcompanion.ordersystem.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    //создать новый заказ
    public Order createOrder(CreateOrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(request.getCustomerId()));
        Order newOrder = new Order().builder()
                .description(request.getDescription())
                .price(request.getPrice())
                .customer(customer)
                .build();

        return orderRepository.save(newOrder);
    }

    //обновить заказ
    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        order.setDescription(orderDetails.getDescription());
        order.setPrice(orderDetails.getPrice());
        order.setStatus(orderDetails.getStatus());

        if (orderDetails.getCustomer() != null) {
            order.setCustomer(orderDetails.getCustomer());
        }
        return orderRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Order> gerOrderByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
}
