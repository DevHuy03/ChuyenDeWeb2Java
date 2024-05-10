package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Order;
import com.macquochuy.exercise02.Repository.OrderRepository;
import com.macquochuy.exercise02.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        order.setCreated_at(new Date());
        order.setUpdated_at(new Date());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> optionalExistingOrder = orderRepository.findById(order.getOrder_id());

        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            existingOrder.setCart(order.getCart());
            existingOrder.setPayment(order.getPayment());
            existingOrder.setOrder_date(order.getOrder_date());
            existingOrder.setOrder_desc(order.getOrder_desc());
            existingOrder.setOrder_fee(order.getOrder_fee());
            existingOrder.setUpdated_at(new Date());

            return orderRepository.save(existingOrder);
        } else {
            // Trả về null nếu đơn hàng không tồn tại
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
