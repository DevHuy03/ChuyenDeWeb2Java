package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    Order updateOrder(Order order);
    void deleteOrder(Long orderId);
}

