package com.aaa.exercise03.service;

import java.util.List;

import com.aaa.exercise03.entity.Order;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrderById(Integer orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);
    
    void deleteOrder(Integer orderId);
}