package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Order;
import com.macquochuy.exercise03.Repository.OrderRepository;
import com.macquochuy.exercise03.service.OrderService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> optionalExistingOrder = orderRepository.findById(order.getId());
        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            existingOrder.setCoupon_id(order.getCoupon_id());
            existingOrder.setCustomer_id(order.getCustomer_id());
            existingOrder.setOrder_status_id(order.getOrder_status_id());
            existingOrder.setOrder_approved_at(new Date());
            existingOrder.setOrder_delivered_carrier_date(new Date());
            existingOrder.setOrder_delivered_customer_date(new Date());
            existingOrder.setOrder_delivered_customer_date(new Date());
            existingOrder.setUpdated_by(order.getUpdated_by());
    
            Order updatedOrder = orderRepository.save(existingOrder);
            return updatedOrder;
        }
    
        return null;
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
