package com.github.goodcompanion.ordersystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @GetMapping("/test")
    public String test(){
        return "Система управления заказами запущена. MySQL успешно подключена!";
    }
}
