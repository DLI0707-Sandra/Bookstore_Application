package com.example.Bookstore.Service;

import com.example.Bookstore.Model.Wishlist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WishlistService{
    public String getAllWishlists(Long productId);
    public String removeFromWishlist(Long productId);
    public String addWishlist();


    List<Wishlist> getAllWishlists();

    Wishlist addWishlist(Wishlist wishlist);

    String deleteWishlist(Long wishlistId);
}
