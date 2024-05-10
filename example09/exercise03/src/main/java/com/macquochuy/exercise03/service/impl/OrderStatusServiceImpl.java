package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.OrderStatus;
import com.macquochuy.exercise03.Repository.OrderStatusRepository;
import com.macquochuy.exercise03.service.OrderStatusService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus createOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus getOrderStatusById(UUID orderStatusId) {
        Optional<OrderStatus> optionalOrderStatus = orderStatusRepository.findById(orderStatusId);
        return optionalOrderStatus.orElse(null);
    }

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
        Optional<OrderStatus> optionalExistingOrderStatus = orderStatusRepository.findById(orderStatus.getId());
        if (optionalExistingOrderStatus.isPresent()) {
            OrderStatus existingOrderStatus = optionalExistingOrderStatus.get();
            existingOrderStatus.setStatus_name(orderStatus.getStatus_name());
            existingOrderStatus.setColor(orderStatus.getColor());
            existingOrderStatus.setPrivacy(orderStatus.getPrivacy());
            existingOrderStatus.setUpdated_at(new Date());
            existingOrderStatus.setCreated_by(orderStatus.getCreated_by());
            existingOrderStatus.setUpdated_by(orderStatus.getUpdated_by());

            OrderStatus updatedOrderStatus = orderStatusRepository.save(existingOrderStatus);
            return updatedOrderStatus;
        }

        return null;
    }

    @Override
    public void deleteOrderStatus(UUID orderStatusId) {
        orderStatusRepository.deleteById(orderStatusId);
    }
}
