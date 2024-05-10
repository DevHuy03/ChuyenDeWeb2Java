package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.OrderItem;

public interface OrderItemService {

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem getOrderItemById(UUID orderItemId);

    List<OrderItem> getAllOrderItems();

    OrderItem updateOrderItem(OrderItem orderItem);
    
    void deleteOrderItem(UUID orderItemId);
}