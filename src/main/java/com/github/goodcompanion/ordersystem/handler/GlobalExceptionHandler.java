package com.github.goodcompanion.ordersystem.handler;

import com.github.goodcompanion.ordersystem.exception.CustomerNotFoundException;
import com.github.goodcompanion.ordersystem.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //обработка CustomerNotFoundException
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerNotFound(CustomerNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Клиент не найден");
        response.put("message", ex.getMessage());
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    //обработка OrderNotFoundException
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleOrderNotFound(OrderNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Заказ не найден");
        response.put("message", ex.getMessage());
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    //отработка ошибок валидации @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        Map<String, String> response = new HashMap<>();
        response.put("error", "Ошибка валидации");
        response.put("message", "Проверьте введенные данные");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //отработка остальных исключений
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Внутренняя ошибка сервера");
        response.put("message", "Произошла непредвиденная ошибка");
        response.put("details", ex.getMessage());
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
