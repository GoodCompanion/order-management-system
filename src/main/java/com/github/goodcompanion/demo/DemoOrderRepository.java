package com.github.goodcompanion.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DemoOrderRepository {
    private final List<DemoOrder> orders = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public DemoOrder save(DemoOrder order) {
        order.setId(idCounter.getAndIncrement());
        orders.add(order);
        return order;
    }

    public List<DemoOrder> findAll() {
        return new ArrayList<>(orders);
    }
}
