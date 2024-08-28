package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.CartItem;
import com.example.Bookstore.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/add_cart_item/{product_id}")
    public String addCartItem(@PathVariable("product_id") Long product_id)
    {
        cartItemService.addItem(product_id);
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
