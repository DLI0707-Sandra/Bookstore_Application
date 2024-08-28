package com.example.Bookstore.Controller;


import com.example.Bookstore.Model.Cart;
import com.example.Bookstore.Model.Wishlist;
import com.example.Bookstore.Model.WishlistItems;
import com.example.Bookstore.Service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
public class WishlistItemController {
    @Autowired
    private WishlistItemService wishlistItemService;

    @GetMapping("/get_wishlist_items")
    public List<WishlistItems> getAllWishlists() {
        return wishlistItemService.getAllWishlists();
    }

    @PostMapping("/add_wishlist_item/{product_id}")
    public String addwishlistItem(@PathVariable("product_id") Long product_id,@RequestBody Wishlist wishlist) {
        if (product_id == null || wishlist == null || wishlist.getUsers() == null || wishlist.getUsers().getUserId() == null) {
            throw new IllegalArgumentException("Product ID and Cart with valid User ID must not be null");
        }
        wishlistItemService.addwishlistItem(product_id,wishlist );
        return "Item added to wishlist!";
    }


    @DeleteMapping("/remove_wishlist_item/{wishlistItem_id}")
        public String deleteWishlistitem(@PathVariable Long wishlistItem_id) {
            return wishlistItemService.deleteWishlistitem(wishlistItem_id);
        }

}
