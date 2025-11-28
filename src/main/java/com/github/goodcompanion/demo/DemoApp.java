package com.github.goodcompanion.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class DemoApp {
    private static final DemoOrderRepository repository = new DemoOrderRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Создать ордер");
            System.out.println("2. Все ордера");
            System.out.println("3. Выйти");
            System.out.println("Выберите вариант");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    listAllOrders();
                    break;
                case 3:
                    System.out.println("До свидания");
                    return;
                default:
                    System.out.println("Неверный вариант");
            }
        }
    }

    private static void createOrder() {
        System.out.println("Введите имя клиента");
        String customerName = scanner.nextLine();

        System.out.println("Введите описание заказа");
        String description = scanner.nextLine();

        System.out.println("Введите цену заказа");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        DemoCustomer customer = new DemoCustomer();
        customer.setName(customerName);

        DemoOrder order = new DemoOrder();
        order.setDescription(description);
        order.setPrice(price);
        order.setCustomer(customer);

        repository.save(order);
        System.out.println("Заказ создан!");
    }

    private static void listAllOrders() {
        List<DemoOrder> orders = repository.findAll();
        if (orders.isEmpty()) {
            System.out.println("Заказов не найдено");
        } else {
            for (DemoOrder order : orders) {
                System.out.println("ID: " + order.getId() +
                        ", Desc: " + order.getDescription() +
                        ", Price: " + order.getPrice() +
                        ", Customer: " + order.getCustomer().getName());
            }
        }
    }
}
