package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
