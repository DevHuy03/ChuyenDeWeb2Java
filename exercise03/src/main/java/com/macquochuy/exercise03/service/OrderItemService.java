package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.OrderItem;

public interface OrderItemService {

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem getOrderItemById(UuidGenerator orderItemId);

    List<OrderItem> getAllOrderItems();

    OrderItem updateOrderItem(OrderItem orderItem);
    
    void deleteOrderItem(UuidGenerator orderItemId);
}