package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Cart;
import com.example.Bookstore.Model.CartItem;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.CartRepository;
import com.example.Bookstore.Repository.UsersRepo;
import com.example.Bookstore.Service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
@Slf4j
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/add_cart_item/{bookId}")
    public String addCartItem(@PathVariable("bookId") Long product_id,@RequestBody Cart cart)
    {
        if (product_id == null || cart == null || cart.getUsers() == null || cart.getUsers().getUserId() == null) {
            throw new IllegalArgumentException("Product ID and Cart with valid User ID must not be null");
        }
        cartItemService.addItem(product_id, cart);
        return "Item added to cart!";
    }

    @PutMapping("/cart_item_quantity/{cartitem_id}")
    public String updateQuantity(@PathVariable Long cartitem_id,@RequestBody int quantity)
    {
        return cartItemService.updateQuantity(cartitem_id,quantity);
    }

    @DeleteMapping("/remove_cart_item/{cartitem_id}")
    public String deleteItem(@PathVariable Long cartitem_id)
    {
        return cartItemService.deleteItem(cartitem_id);
    }

    @GetMapping("/get_cart_items")
    public List<CartItem> getCartItems()
    {
        return cartItemService.getAll();
    }
}
