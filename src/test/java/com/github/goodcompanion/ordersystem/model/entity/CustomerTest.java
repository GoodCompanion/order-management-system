package com.github.goodcompanion.ordersystem.model.entity;

import com.github.goodcompanion.ordersystem.customer.Customer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CustomerTest {
    @Test
    void testCustomerBuilder() {
        String name = "Ivan";
        String phoneNumber = "89375027134";

        Customer customer = Customer.builder().name(name).phoneNumber(phoneNumber).build();
        assertEquals(name, customer.getName());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertNotNull(customer.getRegistrationDate());
        assertEquals(BigDecimal.ZERO, customer.getBalance());

    }
}
