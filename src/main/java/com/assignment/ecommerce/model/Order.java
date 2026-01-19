package com.assignment.ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private String id;

    private String userId;
    private Double totalAmount;
    private String status; // CREATED, PAID, FAILED, CANCELLED
    private Instant createdAt;
}
