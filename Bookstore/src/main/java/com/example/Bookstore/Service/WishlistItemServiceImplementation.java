package com.example.Bookstore.Service;

import com.example.Bookstore.Exception.OutOfStockException;
import com.example.Bookstore.Exception.ProductNotFoundException;
import com.example.Bookstore.Model.*;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.Repository.UsersRepo;
import com.example.Bookstore.Repository.WishlistItemRepository;
import com.example.Bookstore.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class WishlistItemServiceImplementation implements WishlistItemService{

    @Autowired
    WishlistItemRepository wishlistItemRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    WishlistRepository wishlistRepository;

    @Autowired
    UsersRepo usersRepo;

    public List<WishlistItems> getAllWishlists() {
        return wishlistItemRepository.findAll();
    }

    @Override
    public void addwishlistItem(Long productId, Wishlist wishlist) {

            Book book = bookRepository.findById(productId).orElse(null);
            if (book == null) {
                throw new ProductNotFoundException("Product not found!");
            }

            Wishlist wishlist1 = wishlistRepository.findByUserId(wishlist.getUsers().getUserId()).orElse(null);
            if (wishlist1 == null) {
                wishlist1 = new Wishlist();
                Users users = usersRepo.findById(wishlist.getUsers().getUserId()).orElse(null);
                if (users != null) {
                    wishlist1.setUsers(users);
                    wishlist1.setCreated_at(LocalDateTime.now());
                    wishlist1.setWishlists(new ArrayList<>());
                    wishlistRepository.save(wishlist1);
                }
            }

            WishlistItems wishlistItem = new WishlistItems();
            wishlistItem.setBook(book);
            wishlistItem.setQuantity(1);
            wishlistItem.setWishlist(wishlist1);
            wishlistItemRepository.save(wishlistItem);

            List<WishlistItems> items = wishlist1.getWishlists();
            items.add(wishlistItem);
            wishlist1.setWishlists(items);
            wishlistRepository.save(wishlist1);


    }

    @Override
    public String deleteWishlistitem(Long wishlistId) {

        WishlistItems wishlistItems=wishlistItemRepository.findById(wishlistId).orElse(null);
        if(wishlistItems!=null)
        {
            Wishlist wishlist=wishlistRepository.findById(wishlistItems.getWishlist().getId()).orElse(null);
            List<WishlistItems>old=wishlist.getWishlists();
            old.remove(wishlistItems);
            wishlist.setWishlists(old);
            wishlistRepository.save(wishlist);
            wishlistItemRepository.delete(wishlistItems);
            return "Item deleted from wishlist!";
        }
        else
            return "Item not found in wishlist!";
    }


}





