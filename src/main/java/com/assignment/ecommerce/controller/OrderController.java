package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.dto.CreateOrderRequest;
import com.assignment.ecommerce.model.Order;
import com.assignment.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public String test() {
        return "Order controller working";
    }


    // POST /api/orders
    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request.getUserId());
    }

    // GET /api/orders/{orderId}
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }
}
