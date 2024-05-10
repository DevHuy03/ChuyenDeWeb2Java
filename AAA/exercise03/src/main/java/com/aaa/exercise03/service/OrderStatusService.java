package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.OrderStatus;

public interface OrderStatusService {

    OrderStatus createOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(UUID orderStatusId);

    List<OrderStatus> getAllOrderStatuses();

    OrderStatus updateOrderStatus(OrderStatus orderStatus);
    
    void deleteOrderStatus(UUID orderStatusId);
}