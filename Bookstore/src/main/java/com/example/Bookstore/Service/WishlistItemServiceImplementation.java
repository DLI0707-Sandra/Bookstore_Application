package com.example.Bookstore.Service;

import com.example.Bookstore.Model.WishlistItems;
import com.example.Bookstore.Repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WishlistItemServiceImplementation implements WishlistItemService{

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Override
    public List<WishlistItems> getAllWishlists() {
        return wishlistItemRepository.findAll();
    }

    @Override
    public String deleteWishlist(Long wishlistId) {
        if (wishlistItemRepository.existsById(wishlistId)) {
            wishlistItemRepository.deleteById(wishlistId);
            return "Wishlist deleted successfully";
        }
        return "Wishlist not found";
    }
    }
