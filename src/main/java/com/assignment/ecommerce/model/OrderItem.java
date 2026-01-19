package com.assignment.ecommerce.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    private String id;

    private String orderId;
    private String productId;
    private Integer quantity;
    private Double price; // price at order time
}
