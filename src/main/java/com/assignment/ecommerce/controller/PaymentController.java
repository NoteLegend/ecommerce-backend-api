package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.dto.PaymentRequest;
import com.assignment.ecommerce.model.Payment;
import com.assignment.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // POST /api/payments
    @PostMapping
    public Payment makePayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request.getOrderId());
    }
}
