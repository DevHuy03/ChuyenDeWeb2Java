package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.OrderStatus;

public interface OrderStatusService {

    OrderStatus createOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(UuidGenerator orderStatusId);

    List<OrderStatus> getAllOrderStatuses();

    OrderStatus updateOrderStatus(OrderStatus orderStatus);
    
    void deleteOrderStatus(UuidGenerator orderStatusId);
}