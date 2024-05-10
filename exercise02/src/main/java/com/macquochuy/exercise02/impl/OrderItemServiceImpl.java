package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.OrderItem;
import com.macquochuy.exercise02.Repository.OrderItemRepository;
import com.macquochuy.exercise02.service.OrderItemService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        orderItem.setCreated_at(new Date());
        orderItem.setUpdated_at(new Date());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        return optionalOrderItem.orElse(null);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> optionalExistingOrderItem = orderItemRepository.findById(orderItem.getOrder_item_id());

        if (optionalExistingOrderItem.isPresent()) {
            OrderItem existingOrderItem = optionalExistingOrderItem.get();
            existingOrderItem.setProduct(orderItem.getProduct());
            existingOrderItem.setOrder(orderItem.getOrder());
            existingOrderItem.setOrder_quantity(orderItem.getOrder_quantity());
            existingOrderItem.setUpdated_at(new Date());

            return orderItemRepository.save(existingOrderItem);
        } else {
            // Trả về null nếu mục đơn hàng không tồn tại
            return null;
        }
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
