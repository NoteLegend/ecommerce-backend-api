package com.assignment.ecommerce.service;

import com.assignment.ecommerce.model.Order;
import com.assignment.ecommerce.model.Payment;
import com.assignment.ecommerce.repository.OrderRepository;
import com.assignment.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public Payment processPayment(String orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setCreatedAt(Instant.now());

        // MOCK payment success
        payment.setStatus("SUCCESS");

        paymentRepository.save(payment);

        // Update order status
        order.setStatus("PAID");
        orderRepository.save(order);

        return payment;
    }
}
