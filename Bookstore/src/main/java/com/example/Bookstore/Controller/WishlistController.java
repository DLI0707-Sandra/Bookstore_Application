package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Wishlist;
import com.example.Bookstore.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

//    @GetMapping("/bookstore_user/get_wishlist_items")
//    public List<Wishlist> getAllWishlists() {
//        return wishlistService.getAllWishlists();
//    }

    @PostMapping("/bookstore_user/add_wishlist_item/{product_id}")
    public Wishlist addWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.addWishlist(wishlist);
    }

//    @DeleteMapping("/bookstore_user/delete_wishlist_item/{product_id}")
//    public String deleteWishlist(@PathVariable Long id) {
//        return wishlistService.deleteWishlist(id);
//    }
    }

