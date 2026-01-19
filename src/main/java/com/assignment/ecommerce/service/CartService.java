package com.assignment.ecommerce.service;

import com.assignment.ecommerce.dto.AddToCartRequest;
import com.assignment.ecommerce.model.CartItem;
import com.assignment.ecommerce.model.Product;
import com.assignment.ecommerce.repository.CartRepository;
import com.assignment.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository,
                       ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Add item to cart
    public CartItem addToCart(AddToCartRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        List<CartItem> userCart = cartRepository.findByUserId(request.getUserId());

        for (CartItem item : userCart) {
            if (item.getProductId().equals(request.getProductId())) {
                item.setQuantity(item.getQuantity() + request.getQuantity());
                return cartRepository.save(item);
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setUserId(request.getUserId());
        cartItem.setProductId(request.getProductId());
        cartItem.setQuantity(request.getQuantity());

        return cartRepository.save(cartItem);
    }

    // Get user's cart
    public List<CartItem> getUserCart(String userId) {
        return cartRepository.findByUserId(userId);
    }

    // Clear cart
    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}
