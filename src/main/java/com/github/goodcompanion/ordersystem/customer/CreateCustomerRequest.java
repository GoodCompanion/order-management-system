package com.github.goodcompanion.ordersystem.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateCustomerRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    private String phoneNumber;
    
}
