package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.OrderItem;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long orderItemId);
    List<OrderItem> getAllOrderItems();
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long orderItemId);
}
