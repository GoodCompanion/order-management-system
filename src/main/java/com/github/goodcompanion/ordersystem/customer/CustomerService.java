package com.github.goodcompanion.ordersystem.customer;

import com.github.goodcompanion.ordersystem.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    //создать нового покупателя
    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder().name(request.getName()).email(request.getEmail()).phoneNumber(request.getPhoneNumber()).build();
        return customerRepository.save(customer);
    }
}
