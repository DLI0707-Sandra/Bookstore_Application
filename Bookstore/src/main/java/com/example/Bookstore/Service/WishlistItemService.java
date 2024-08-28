package com.example.Bookstore.Service;


import com.example.Bookstore.Model.Wishlist;
import com.example.Bookstore.Model.WishlistItems;

import java.util.List;

public interface WishlistItemService {

    List<WishlistItems> getAllWishlists();

    void addwishlistItem(Long productId, Wishlist wishlist);

    String deleteWishlistitem(Long wishlistId);

}
