package com.example.Bookstore.Service;
import com.example.Bookstore.Model.Wishlist;
import com.example.Bookstore.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistServiceImplementation implements WishlistService{

        @Autowired
        private WishlistRepository wishlistRepository;

//    @Override
//    public String getAllWishlists(Long productId) {
//        return "";
//    }
//
//    @Override
//    public String removeFromWishlist(Long productId) {
//        return "";
//    }
//
//    @Override
//    public String addWishlist() {
//        return "";
//    }

//    @Override
//        public List<Wishlist> getAllWishlists() {
//            return wishlistRepository.findAll();
//        }

//    @Override
//    public String addWishlist() {
//        return "";
//    }

    @Override
        public Wishlist addWishlist(Wishlist wishlist) {
            return wishlistRepository.save(wishlist);
        }

//        @Override
//        public String deleteWishlist(Long wishlistId) {
//            if (wishlistRepository.existsById(wishlistId)) {
//                wishlistRepository.deleteById(wishlistId);
//                return "Wishlist deleted successfully";
//            }
//            return "Wishlist not found";
        }

