package com.assignment.ecommerce.repository;

import com.assignment.ecommerce.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    Payment findByOrderId(String orderId);
}
