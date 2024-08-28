package com.example.Bookstore.Service;

import com.example.Bookstore.Model.CartItem;

import java.util.List;

public interface CartItemService {
    void addItem(Long productId);

    String  updateQuantity(Long cartitemId,int count);

    String deleteItem(Long id);

    List<CartItem> getAll();
}
