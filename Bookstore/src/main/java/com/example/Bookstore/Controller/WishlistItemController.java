package com.example.Bookstore.Controller;


import com.example.Bookstore.Model.WishlistItems;
import com.example.Bookstore.Service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishlistItemController {
    @Autowired
    private WishlistItemService wishlistItemService;

    @GetMapping("/bookstore_user/get_wishlist_items")
    public List<WishlistItems> getAllWishlists() {
        return wishlistItemService.getAllWishlists();
    }


    @DeleteMapping("/bookstore_user/delete_wishlist_item")
    public String deleteWishlist(Long wishlistId) {
        return wishlistItemService.deleteWishlist(wishlistId);
    }

}
