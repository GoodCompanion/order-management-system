package com.github.goodcompanion.ordersystem.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCustomerRequest {
    @NotBlank
    @NotNull(message = "Имя покупателя обязательное")
    private String name;
    @Email
    @NotNull(message = "Email обязательное поле")
    private String email;
    @NotNull(message = "Номер телефона обязательное поле")
    private String phoneNumber;

    public CreateCustomerRequest() {
    }

    public CreateCustomerRequest(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
