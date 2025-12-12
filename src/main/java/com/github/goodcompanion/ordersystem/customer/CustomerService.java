package com.github.goodcompanion.ordersystem.customer;

import com.github.goodcompanion.ordersystem.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    //получить всех покупателей
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //получить покупателя по id
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    //создать нового покупателя
    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder().name(request.getName()).email(request.getEmail()).phoneNumber(request.getPhoneNumber()).build();
        return customerRepository.save(customer);
    }
}
