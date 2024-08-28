package com.example.Bookstore.Service;


import com.example.Bookstore.Model.WishlistItems;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WishlistItemService {

    List<WishlistItems> getAllWishlists();
    String deleteWishlist(Long wishlistId);


}
