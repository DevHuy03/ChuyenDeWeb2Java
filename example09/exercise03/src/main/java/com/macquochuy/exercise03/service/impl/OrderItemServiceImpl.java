package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.OrderItem;
import com.macquochuy.exercise03.Repository.OrderItemRepository;
import com.macquochuy.exercise03.service.OrderItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(UUID orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        return optionalOrderItem.orElse(null);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> optionalExistingOrderItem = orderItemRepository.findById(orderItem.getId());
        if (optionalExistingOrderItem.isPresent()) {
            OrderItem existingOrderItem = optionalExistingOrderItem.get();
            existingOrderItem.setProduct_id(orderItem.getProduct_id());
            existingOrderItem.setOrder_id(orderItem.getOrder_id());
            existingOrderItem.setPrice(orderItem.getPrice());
            existingOrderItem.setQuantity(orderItem.getQuantity());

            OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
            return updatedOrderItem;
        }

        return null;
    }

    @Override
    public void deleteOrderItem(UUID orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
