package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Payment;
import com.macquochuy.exercise02.Repository.PaymentRepository;
import com.macquochuy.exercise02.service.PaymentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        payment.setCreated_at(new Date());
        payment.setUpdated_at(new Date());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Optional<Payment> optionalExistingPayment = paymentRepository.findById(payment.getPayment_id());

        if (optionalExistingPayment.isPresent()) {
            Payment existingPayment = optionalExistingPayment.get();
            existingPayment.setOrder(payment.getOrder());
            existingPayment.setPayed(payment.isPayed());
            existingPayment.setPayment_status(payment.getPayment_status());
            existingPayment.setUpdated_at(new Date());

            return paymentRepository.save(existingPayment);
        } else {
            // Trả về null nếu thanh toán không tồn tại
            return null;
        }
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
