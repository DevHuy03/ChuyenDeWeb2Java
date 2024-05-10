package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.Payment;
import com.macquochuy.exercise02.service.PaymentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    // Create Payment REST API
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    // Get Payment by id REST API
    // http://localhost:8080/api/payments/1
    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    // Get All Payments REST API
    // http://localhost:8080/api/payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Update Payment REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/payments/1
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Long paymentId,
                                                 @RequestBody Payment payment) {
        payment.setPayment_id(paymentId); // Thiết lập id cho payment cần cập nhật
        Payment updatedPayment = paymentService.updatePayment(payment);
        if (updatedPayment != null) {
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Payment REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") Long paymentId) {
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment successfully deleted!", HttpStatus.OK);
    }
}
