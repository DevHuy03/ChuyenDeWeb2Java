package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.OrderItem;
import com.macquochuy.exercise03.service.OrderItemService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orderItems")
public class OrderItemController {

    private OrderItemService orderItemService;

    // Create OrderItem REST API
    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemService.createOrderItem(orderItem);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }

    // Get OrderItem by id REST API
    // http://localhost:8080/api/orderItems/{id}
    @GetMapping("{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id") UuidGenerator orderItemId) {
        OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    // Get All OrderItems REST API
    // http://localhost:8080/api/orderItems
    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    // Update OrderItem REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/orderItems/{id}
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable("id") UuidGenerator orderItemId,
                                                      @RequestBody OrderItem orderItem) {
        orderItem.setId(orderItemId);
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);
        if (updatedOrderItem != null) {
            return new ResponseEntity<>(updatedOrderItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete OrderItem REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable("id") UuidGenerator orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
        return new ResponseEntity<>("OrderItem successfully deleted!", HttpStatus.OK);
    }
}
