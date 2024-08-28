package com.example.Bookstore.Service;
import com.example.Bookstore.Model.Wishlist;
import com.example.Bookstore.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistServiceImplementation implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;


    @Override
    public Wishlist addWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }
}

