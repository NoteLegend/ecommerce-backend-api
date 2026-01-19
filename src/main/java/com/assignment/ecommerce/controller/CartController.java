package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.dto.AddToCartRequest;
import com.assignment.ecommerce.model.CartItem;
import com.assignment.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // POST /api/cart/add
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody AddToCartRequest request) {
        return cartService.addToCart(request);
    }

    // GET /api/cart/{userId}
    @GetMapping("/{userId}")
    public List<CartItem> getUserCart(@PathVariable String userId) {
        return cartService.getUserCart(userId);
    }

    // DELETE /api/cart/{userId}/clear
    @DeleteMapping("/{userId}/clear")
    public String clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        return "Cart cleared successfully";
    }
}
